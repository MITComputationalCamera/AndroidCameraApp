AndroidCameraApp
================

Uses CWAC (CommonsWare) camera to show and manipulate the camera

Download the library (JAR) at the link below and drop the .jar file into your app's 'libs' folder (create one if it's not there)

https://github.com/commonsguy/cwac-camera

^^also use this link to reference any other methods you'd like to "Override" in the library.

1. Make sure MinSDK is 11 (not 8) or 15 if you're working with Google Glass
2. The 5 files you need to manipulate: MainActivity.java, SuperCamera.manifest, RohanCamHost.java, RohanCamFragment.java, and activity_main.xml
3. Add the following permissions to your AndroidManifest (Allows us to use most of the functions of the CWAC library)

        
    <uses-permission android:name="android.permission.CAMERA" />
    <uses-feature android:name="android.hardware.camera" />
    <uses-feature android:name="android.hardware.camera.autofocus" />
    <uses-permission android:name="android.permission.RECORD_AUDIO" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />


4. Inside the AndroidManifest's "application" tag add the following line:
            android:largeHeap="true"

5. In your activity_main.xml layout file, hange the RelativeLayout to a FrameLayout (this gives us the ability to overlay components on top of other compontents)
6. If you want the viewfinder to take up the enitre screen, make sure you define the width/height of the elemtns to "fill_parent"

<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    tools:context=".MainActivity" >
    
      <fragment
        android:id="@+id/RohanCamFragment"
        android:name="com.example.supercamera.RohanCamFragment"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent" />

</FrameLayout>

The android:name should reference whatever your app's name/path to the fragment file. E.g. My fragment class in my app (called SuperCamera) is called RohanCamFragment.java and thus I refer to it as com.example.supercamera.RohanCamFragment

7. Most of the code you will need to modify will be in MainActivity.java (UI interaction and checks for camera) and RohanCamHost.java (set camera properties)
