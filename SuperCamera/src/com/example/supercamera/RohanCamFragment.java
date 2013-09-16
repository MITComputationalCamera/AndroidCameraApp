package com.example.supercamera;

import android.os.Bundle;

import com.commonsware.cwac.camera.CameraFragment;

public class RohanCamFragment extends CameraFragment {
	@Override
	 public void onCreate(Bundle state) {
		    super.onCreate(state);

		    setHasOptionsMenu(true);
		    
		    //I set my host to my custom CamHost which overrides adjustPreviewParameters and adjustPictureParameters
		    //with the picture and preview parameters that I want for my app.
		    setHost(new RohanCamHost(getActivity()));
		  }

}
