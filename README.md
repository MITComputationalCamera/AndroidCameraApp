## Setup
***

Uses CWAC (CommonsWare) camera to show and manipulate the camera

Download the library (JAR) at the link below and drop the .jar file into your app's 'libs' folder (create one if it's not there)

[https://github.com/commonsguy/cwac-camera](https://github.com/commonsguy/cwac-camera)
also use this link to reference any other methods you'd like to "Override" in the library.

1. Make sure MinSDK is 11 (not 8) or 15 if you're working with Google Glass
2. The 5 files you need to manipulate: MainActivity.java, SuperCamera.manifest, RohanCamHost.java, RohanCamFragment.java, and activity_main.xml
3. Add the following permissions to your AndroidManifest (already included in source code above; allows us to use most of the functions of the CWAC library)


```xml
<uses-permission android:name="android.permission.CAMERA"/>
<uses-feature android:name="android.hardware.camera"/>
<uses-feature android:name="android.hardware.camera.autofocus"/>
<uses-permission android:name="android.permission.RECORD_AUDIO"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```
4. Inside the AndroidManifest's "application" tag add the following line (already included in source code above):
`android:largeHeap="true"`
5. In your activity_main.xml layout file, change the RelativeLayout to a FrameLayout (this gives us the ability to overlay components on top of other compontents) (already included in source code above)
6. If you want the viewfinder to take up the enitre screen, make sure you define the width/height of the elements to "fill_parent"


```xml
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
```

7. The android:name should reference whatever your app's name/path to the fragment file. E.g. The fragment class in my app (called SuperCamera) is called RohanCamFragment.java and thus I refer to it as com.example.supercamera.RohanCamFragment

8. Most of the code you will need to modify will be in RohanCamHost.java

## Assignment (HW2)
***
You will be modifying the code included in this repository to create a document scanner app!

Similar to CamScanner (https://play.google.com/store/apps/details?id=com.intsig.camscannerhd), you will be adjusting the properties of the camera (flash, scene, color effect),
to take a picture of a printed word document, enhance the brightness/contrast of the image to look more like a scan (https://lh3.ggpht.com/jfjr64-6SZpeGOS74xgIGsMvnpCgPLwtCXjB2a9zo5X10Pv_4iZIMm7le1IzR_uYgj4=h900-rw), and save the image onto the device.

The project above handles starting/stopping the camera for you and just requires you to change the camera parameters and create a method that modifies the brightness/contrast of the bitmap image.

As the code currently stands, it saves the images automatically in your phone's DCIM folder. I recommend using an app like ES File Explorer to view the images you've taken with the app (https://play.google.com/store/apps/details?id=com.estrongs.android.pop&hl=en)

As always, feel free to use the vastness of the internet to your advantage here. All external libraries/code are acceptable -- just make sure you understand what you're implementing.

You only need to modify the code indicated by the //*********** INSERT/MODIFY CODE HERE blocks.
