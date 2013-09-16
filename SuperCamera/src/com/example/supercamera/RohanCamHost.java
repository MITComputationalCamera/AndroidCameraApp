package com.example.supercamera;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.MediaScannerConnection;
import android.util.Log;


import com.commonsware.cwac.camera.SimpleCameraHost;

public class RohanCamHost extends SimpleCameraHost {

	public RohanCamHost(Context _ctxt) {
		super(_ctxt);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Camera.Parameters adjustPreviewParameters(Camera.Parameters parameters){
		
		//***********MODIFY CODE here to adjust the properties to BEST scan a document image. For example, you may want macro mode, flash on, etc. so you can get the best image but 
		//***********use what features your device has onboard (e.g. not all devices support macro mode). User the internet to find the best settings here
		//Again, here is what CamScanner looks like: https://lh3.ggpht.com/jfjr64-6SZpeGOS74xgIGsMvnpCgPLwtCXjB2a9zo5X10Pv_4iZIMm7le1IzR_uYgj4=h900-rw
		
		
		
		//=============================
		//Sets Parameters of the Preview (viewfinder)
		//REMEMBER: NOT ALL OF THESE WILL WORK FOR YOUR CAMERA -- ENABLING THESE PARAMETERS MIGHT CRASH YOUR APP. Check if you have the setting
		//first by doing a "get" call
		//API reference: http://developer.android.com/reference/android/hardware/Camera.Parameters.html
		//CWAC Library info: https://github.com/commonsguy/cwac-camera
		//=============================
		
		
		//parameters.setAntibanding(Parameters.ANTIBANDING_AUTO); //ANTIBANDING_50HZ, ANTIBANDING_60HZ, ANTIBANDING_AUTO, ANTIBANDING_OFF
		
		//parameters.setAutoExposureLock(false);//boolean true/false // REQS API Level 14
		
		//parameters.setAutoWhiteBalanceLock(false);//boolean true/false //REQS API Level 14
		
			//parameters.setColorEffect(Parameters.EFFECT_MONO);//EFFECT_AQUA, EFFECT_BLACKBOARD, EFFECT_MONO, EFFECT_NEGATIVE, EFFECT_NONE,
			//EFFECT_POSTERIZE, EFFECT_SEPIA, EFFECT_SOLARIZE, EFFECT_WHITEBOARD
	
			
		//parameters.setExposureCompensation(0); //place an int here. Every camera is different so check what options are available using
									//the range between getMinExposureCompensation() and getMaxExposureCompensation()
	
		//parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);//FLASH_MODE_AUTO, FLASH_MODE_ON, FLASH_MODE_OFF, FLASH_MODE_TORCH, FLASH_MODE_RED_EYE
		
		//parameters.setFocusAreas(); //Each focus area is a rectangle with specified weight. The direction is relative to the sensor orientation, 
							//that is, what the sensor sees.Only works when the following Focus Modes are enabled FOCUS_MODE_AUTO, FOCUS_MODE_MACRO, FOCUS_MODE_CONTINUOUS_VIDEO, or FOCUS_MODE_CONTINUOUS_PICTURE	
		
		parameters.setFocusMode(Parameters.FOCUS_MODE_AUTO); //FOCUS_MODE_AUTO, FOCUS_MODE_INFINITY, FOCUS_MODE_MACRO, FOCUS_MODE_FIXED, FOCUS_MODE_EDOF, FOCUS_MODE_CONTINUOUS_VIDEO
		 
		//parameters.setMeteringAreas(List<Camera.Area> meteringAreas) //Sets the metering area, which in combo with the focus area decides exposure
		
		//parameters.setPictureFormat() //ImageFormat.NV21 (preview format), ImageFormat.RGB_565 (16-bit color), or ImageFormat.JPEG
		
		//parameters.setPreviewFpsRange (5000, 120000); // Check what is supported by the camera with getSupportedPreviewFpsRange() the range 5000-120000 is the only range supported by Nexus4
		
		//parameters.setRotation() -- you can use 0, 90, 180, or 270 here
		
		parameters.setSceneMode(Parameters.SCENE_MODE_AUTO); 
		/*You can use the following (depending on camera)
		 *  SCENE_MODE_ACTION	Take photos of fast moving objects.
			SCENE_MODE_AUTO	Scene mode is off.
			SCENE_MODE_BARCODE	Applications are looking for a barcode.
			SCENE_MODE_BEACH	Take pictures on the beach.
			SCENE_MODE_CANDLELIGHT	Capture the naturally warm color of scenes lit by candles.
			SCENE_MODE_FIREWORKS	For shooting firework displays.
			SCENE_MODE_HDR	Capture a scene using high dynamic range imaging techniques.
			SCENE_MODE_LANDSCAPE	Take pictures on distant objects.
			SCENE_MODE_NIGHT	Take photos at night.
			SCENE_MODE_NIGHT_PORTRAIT	Take people pictures at night.
			SCENE_MODE_PARTY	Take indoor low-light shot.
			SCENE_MODE_PORTRAIT	Take people pictures.
			SCENE_MODE_SNOW	Take pictures on the snow.
			SCENE_MODE_SPORTS	Take photos of fast moving objects.
			SCENE_MODE_STEADYPHOTO	Avoid blurry pictures (for example, due to hand shake).
			SCENE_MODE_SUNSET	Take sunset photos.
			SCENE_MODE_THEATRE	Take photos in a theater.
		 */
		
		//parameters.setVideoStabilization(true);// true or false requires API Level 15
		
		//parameters.setWhiteBalance(Parameters.WHITE_BALANCE_FLUORESCENT);
		/*You can use the following (depending on camera)
		 *  String	WHITE_BALANCE_CLOUDY_DAYLIGHT	
			String	WHITE_BALANCE_DAYLIGHT	
			String	WHITE_BALANCE_FLUORESCENT	
			String	WHITE_BALANCE_INCANDESCENT	
			String	WHITE_BALANCE_SHADE	
			String	WHITE_BALANCE_TWILIGHT	
			String	WHITE_BALANCE_WARM_FLUORESCENT
		 */
		
		//parameters.setZoom(); //check isZoomSupported() and getMaxZoom() for range here
		
		return(parameters);
	}
	public Camera.Parameters adjustPictureParameters(Camera.Parameters parameters){
		//***********MODIFY CODE here to adjust the properties to BEST scan a document image. For example, you may want macro mode, flash on, etc. so you can get the best image but 
		//***********use what features your device has onboard (e.g. not all devices support macro mode). User the internet to find the best settings here
		//Again, here is what CamScanner looks like: https://lh3.ggpht.com/jfjr64-6SZpeGOS74xgIGsMvnpCgPLwtCXjB2a9zo5X10Pv_4iZIMm7le1IzR_uYgj4=h900-rw
				
				
		//===========================
		//Sets Parameters of the Picture (saved onto your device)
		//REMEMBER: NOT ALL OF THESE WILL WORK FOR YOUR CAMERA -- ENABLING THESE PARAMETERS MIGHT CRASH YOUR APP. Check if you have the setting
		//first by doing a "get" call
		//API reference: http://developer.android.com/reference/android/hardware/Camera.Parameters.html
		//===========================
		

		return parameters;

	}
	
	@Override
	public void saveImage(Bitmap bitmap){
		
		
		
		//Here we call the function you made below (magicAdjust) to enhance the image before we save it to the phone	
		
		bitmap = magicAdjust(bitmap);
		
		
		
		
		
		
		
		
		
		
		
		File photo=getPhotoPath();

	    if (photo.exists()) {
	      photo.delete();
	    }
	
		
		try {
		       FileOutputStream out = new FileOutputStream(photo.getPath());
		       bitmap.compress(Bitmap.CompressFormat.PNG, 90, out); //if you find that the image is poor in quality, adjust the "90" here to a different compression amount.
		   	   out.close();
		} catch (Exception e) {
		       e.printStackTrace();
		}
			

	}

	
	
	public static Bitmap magicAdjust(Bitmap bmp)
	{
		
		//*************INSERT/MODIFY CODE HERE to change the brightness/contrast of the incoming bitmap image and then return it
		//*************Feel free to use any resources on the Internet here to help guide you on how to 
		//*************adjust the brightnes and contrast of Bitmap images in Java/Android. You may want to look into the "ColorMatrix" and "Paint" classes.
		
		return bmp; //return the new Bitmap image for us to save above
	 
	}

	
	
}


 
