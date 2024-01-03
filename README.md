# Country List
## Tested on
 - Tested using MacOS, with Pixel 5 emulators running 30 and 31
## Installation Instructions
- Download the apk labeled: app-debug.apk
- Open Android Studio and open an empty project
- Set up the emulator and run it
- Once the emulator has fully booted up, go to home screen
- Drag and drop the apk on the emulator
- If Drag and drop doesn't work, you can manually install it using terminal:
- Open a terminal.
- Navigate to the directory where the Android SDK is installed. This is usually in a directory called Android/sdk in your home directory.
- Go to the platform-tools directory by typing cd platform-tools and pressing Enter.
- Connect to the emulator by typing adb connect localhost:<PORTNUMBER> and pressing Enter. 
- Install the APK by typing adb install <path_to_apk> and pressing Enter. Replace <path_to_apk> with the path to your APK file

## Thought Process

I went with an MVVM architecuture for its scalability and separation of concerns. It is also my preferred architecture when it comes to Mobile Apps. I will break them down into how I utilized each of them;

### Models
I have a country data class that defines how the data should look like. CountryRepository is responsible for fetching and handling the data.

### ViewModel
CountryViewModel was reponsible for creating LivaData of the countries and genres and since it was taking in an argument, I had to make use of ViewModeFactory to instantiate it. 

### Views
I only used mainactivity since the scope of the app was relatively small. The countryAdapter was used to design how each card in the recycler view would look like







