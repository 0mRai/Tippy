package com.example.tippy

import android.accounts.AuthenticatorDescription
import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat

private const val TAG =  "MainActivity"
private const val INITIAL_TIP_PERCENT=15
class MainActivity : AppCompatActivity() {
    private lateinit var BaseAmount: EditText
    private lateinit var seekBarTip: SeekBar
    private lateinit var tvTipAmount: TextView
    private lateinit var tvTipPercentLAbel: TextView
    private lateinit var tvTotalAmount: TextView
    private lateinit var tvTipDescription: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BaseAmount=findViewById(R.id.BaseAmount)
        seekBarTip=findViewById(R.id.seekBarTip)
        tvTipAmount=findViewById(R.id.tvTipAmount)
        tvTipPercentLAbel=findViewById(R.id.tvTipPercentLAbel)
        tvTotalAmount=findViewById(R.id.tvTotalAmount)
        tvTipDescription=findViewById(R.id.tvTipDescription)


        seekBarTip.progress= INITIAL_TIP_PERCENT
        tvTipPercentLAbel.text="$INITIAL_TIP_PERCENT%"
        updateTipDescription(INITIAL_TIP_PERCENT)


        seekBarTip.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.i(TAG,"onProgressChanged $progress")
                tvTipPercentLAbel.text="$progress%"
                computeTipAndTotal()
                updateTipDescription(progress)
100
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })
        BaseAmount.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG,"afterTextChanged $s")
                computeTipAndTotal()
            }

        })

    }

    private fun updateTipDescription(tipPercent: Int) {
        val tipDescription=when(tipPercent) {
            in 0..9 -> "Poor"
            in 10..14 -> "Acceptable"
            in 15..19 -> "Good"
            in 20..24 -> "Great"
            else -> "Amazing"
        }

            tvTipDescription.text=tipDescription
        //update the color based on the tipPercent
        val color = ArgbEvaluator().evaluate(
            tipPercent.toFloat()/seekBarTip.max,
            ContextCompat.getColor(this,R.color.color_worst_tip),
            ContextCompat.getColor(this,R.color.color_best_tip)
            )as Int
        tvTipDescription.setTextColor(color)
        }




    private fun computeTipAndTotal() {
        if(BaseAmount.text.isEmpty())
        {
            tvTipAmount.text=""
            tvTotalAmount.text=""
            return
        }
        //get the value of base and tip
        val baseamount=BaseAmount.text.toString().toDouble();
        val tipPercent=seekBarTip.progress;
        //compute the tip and total
        val tipamount=baseamount * tipPercent/100
        val totalamount=tipamount+baseamount
        //updating the UI
        tvTipAmount.text="%.2f".format(tipamount)
        tvTotalAmount.text="%.2f".format(totalamount)
    }
}