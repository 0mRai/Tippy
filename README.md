##Add extensions to this repository-
Here are some ideas:
- Change the color scheme of the app, e.g. the background/primary/secondary color.
- Modify the theme at app/src/main/res/values/theme.xml
- Replace the text describing the tip (“poor”, “good”, etc) with emojis.
- Improve the user interface through styling and coloring, e.g. change the text color, font,
  optimize the layout for different screens. See the styling screens FAQ.
- Add the ability to split the bill across any number of people.
  (Advanced) Show currency symbols, and allow the user to change their currency.
- Store the currency in SharedPreferences
- (Advanced) Add another screen to the app where you can see tips made in the past.
- Use intents to add another screen to your app.

# CONTRIBUTION GUIDE

If you are new to open-source contribution and don't know how to get started, don't worry, this is a deatiled step by step guide to help you make your first contribution.

Before heading any further, open terminal and run `git --version` to make sure that git is installed on your machine, if not, install it from [here](https://git-scm.com/downloads).

## Fork this repository

In order to make any changes to this repository, fork it by clicking on the fork button. This will create a copy of this repository in your account.

## Clone the repository

Now, to clone this repository to your local machine, copy the url of the forked repository.

Now, open a terminal and run the following command:

```
git clone <copied- url>
```
Here, replace `<copied-url>` with the url of the forked repository you just copied.

## Create a branch

After cloning the repository, change the current working directory to the repository directory by running the following command:


```
cd dimencart
```
Before making any changes, make sure to always create a new branch. To create a new brach run the following command:

```
git checkout -b branch-name
```
You can run `git branch` command to check your branch status.

## Make changes

Now you are all set to make changes. For that you can use any text editor, but I will recommend using Vs Code as it feature rich and easy to use. If VS Code is already installed on your machine, run the following command:

```
code .
```
It will open all the files in VS Code.

After making the changes, run `git status` command. It will show you all the changes you have made.

## Commit those changes

Now, before commiting the changes you will have to add those changes to the branch you created. For that run the following command:
```
git add .
````
Now commit those changes by running the following command:
```
git commit -m "put-your-message-here"
```

## Push to GitHub

Finally push the changes you made to github by running the following command:

```
git push origin -u <your-branch-name>
```

Replace `<your-branch-name>` with the name of the branch you created earlier.

## Submit the pull request

Now open your browser, here you will see a notification. Juslt click on **compare & pull request**.

Now submit the pull request.

Soon your pull request will be reviewed and merged. You will be notified via email once your pull request has been merged.

Congratulations!! You have successfully raised your first pull request. Share on your socials.

**Happy Contributing!!**

# Tip Calculator

## *Om Narain Rai*

**Tippy** computes the tip and total amount for a bill. The app uses the base amount and tip percentage to calculate the amount owed, and it also describes the quality of service based on the tip.

Time spent: **10** hours spent in total

## Functionality

The following **required** functionality is completed:

* [x] User can enter in a bill amount (total amount to tip on)
* [x] User can enter a tip percentage (what % the user wants to tip).
* [x] The tip and total amount are updated immediately when any of the inputs changes.
* [x] The user sees a label or color update based on the tip amount.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://j.gifs.com/mqg4DO.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />
