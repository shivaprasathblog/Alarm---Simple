package com.example.simplealarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.rtp.RtpStream;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	EditText timeinseconds;
	Button setalarm;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		timeinseconds= (EditText)findViewById(R.id.editText1);
		setalarm=(Button)findViewById(R.id.button1);
		
		
		setalarm.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				
				int alarmtime=Integer.parseInt(timeinseconds.getText().toString());
				int alarmtimeintoseconds =alarmtime*1000;
				
				
				Intent i =new Intent(MainActivity.this,MyAlarmClass.class);
				
				//PendingIntent pi =PendingIntent.getBroadcast(context, requestCode, intent, flags)
				
				PendingIntent pi =PendingIntent.getBroadcast(MainActivity.this,123, i,0);
				
				AlarmManager am= (AlarmManager)getSystemService(ALARM_SERVICE);
				
				//am.set(type, triggerAtMillis, operation)
				
				am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+alarmtimeintoseconds, pi);
				
				Toast.makeText(MainActivity.this,"Alarm is set in "+alarmtime +" Seconds", Toast.LENGTH_LONG).show();
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
