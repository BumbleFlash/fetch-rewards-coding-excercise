# Fetch Rewards Coding Excecise
[![API](https://img.shields.io/badge/API-16%2B-green.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![Android CI](https://github.com/CUTR-at-USF/MUSER/workflows/Android%20CI/badge.svg)](https://github.com/CUTR-at-USF/MUSER/actions?query=workflow%3A%22Android+CI%22)

Simple Android app that fetches data from an API. The app was developed as part of the coding excerise provided by Fetch Rewards. 

### Prerequisites for both Android Studio and Gradle

1. Clone this repository
2. Install [Java Development Kit (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

### Building in Android Studio (Recommended)
1. Download, install, and run the latest version of [Android Studio](http://developer.android.com/sdk/installing/studio.html).
2. At the welcome screen select `Import Project`, browse to the location of this repository and select it then select Ok.
3. Open the Android SDK Manager (Tools->Android->SDK Manager) and add a checkmark for the necessary API level (see `compileSdkVersion` in `fetch-rewards-coding-excercise app/build.gradle` then select OK.
4. Connect a [debugging enabled](https://developer.android.com/tools/device.html) Android device to your computer or setup an Android Virtual Device (Tools->Andorid->AVD Manager).
5. Click the green play button (or Alt+Shift+F10) to build and run the project!

### Building in Command line using Gradle
1. Set the `JAVA_HOME` environmental variables to point to your JDK folder (e.g. `C:\Program Files\Java\jdk1.8.0_281`)
2. Download and install the [Android SDK](http://developer.android.com/sdk/index.html). Make sure to install the Google APIs for your API level (e.g. 17), the Android SDK Build-tools version for your `buildToolsVersion` version, the Android Support Repository and the Google Repository.
3. Set the `ANDROID_HOME` environmental variable to your Android SDK location.
4. To build and push the app to the device, run `gradlew installDebug` from the command line at the root of the project.
5. Open the "Fetch Rewards Coding Exercise" on your phone.

## License

```
Copyright 2021 Sudarshan Sampathkumar
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
   
```
