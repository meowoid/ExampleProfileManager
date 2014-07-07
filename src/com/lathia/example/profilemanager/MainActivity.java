package com.lathia.example.profilemanager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(new ProfileListAdapter(this));
	}

}
