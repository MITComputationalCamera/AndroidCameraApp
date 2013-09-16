package com.example.supercamera;

import com.commonsware.cwac.camera.CameraFragment;
import com.commonsware.cwac.camera.CameraHost;
import com.commonsware.cwac.camera.SimpleCameraHost;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	private CameraFragment camerafragment;
	private Button snapButton, recordButton;
	private boolean isRecording = false;
	private RohanCamHost camhost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Check for camera on device
		PackageManager pm = this.getPackageManager();
		
		if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
			Log.e("err", "Device has no camera!");
			return;
		}

		// Initialize the Fragment
		camerafragment = (CameraFragment) getFragmentManager().findFragmentById(
				R.id.RohanCamFragment);

		//Bring in our camera host so we can change things
		camhost = new RohanCamHost(getApplicationContext());
		
		

		// Bring in the camera picture capture button
		snapButton = (Button) findViewById(R.id.snap_button);

		// Bring in the camera video capture button
		recordButton = (Button) findViewById(R.id.record_button);

		// Add onClickListener to take a picture
		snapButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				//***********MODIFY CODE HERE to take a picture but instead of the default behavior, save the file as a Bitmap (BMP) image
				//***********You will need to modify the line below (takePicture) slightly to save a Bitmap file instead (see source here: https://github.com/commonsguy/cwac-camera/blob/master/src/com/commonsware/cwac/camera/CameraFragment.java)
				camerafragment.takePicture();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

			};
		});

		
		// Add onClickListener to take a video
		recordButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				if (!isRecording) {
						try {
							
							//start recording
							camerafragment.record();
							
							//change my boolean to reflect this so I can keep track
							isRecording = true;
							
							//change my text color on the button so I can indicate that I'm recording
							recordButton.setText("Recording");
							recordButton.setTextColor(Color.RED);
							
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
							isRecording=false;
						}
				} 
				else {
					try {
						camerafragment.stopRecording();
						isRecording=false;
						recordButton.setText("Record");
						recordButton.setTextColor(Color.BLACK);
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						isRecording=false;
					}
				}

			};
		});

	
			

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	

	
	
}
