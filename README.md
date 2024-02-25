I created a basic XML Android native login app which I have automated. 

The automation was completed using espresso and written in Kotlin with a JUnit Runner.

ESPRESSO 
The automated test live within "com/android/chiploginapp/ChipLoginTest.kt" 

There are three tests to verify this login app:

1. Some assertions to verify the visibility of the UI elements in the app

2. A positive test with valid login credentials.

3. A negative test with invalid login credentials.

To run the espresso test, use Android devices (emulators or physical) and make sure the animation is turned off via developer mode

IMPROVEMENTS 

Two improvements I will make to this framework in the feature will be to add a feature file/cucumber and also possibly integrate a page object model(POM)
