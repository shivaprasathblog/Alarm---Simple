package com.example.simplealarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyAlarmClass extends BroadcastReceiver 
{

	@Override
	public void onReceive(Context arg0, Intent arg1) 
	{
		// TODO Auto-generated method stub
		Toast.makeText(arg0,"Wake Up !!! Time is UP!!!", Toast.LENGTH_LONG).show();
	}

}
