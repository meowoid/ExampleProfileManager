package com.lathia.example.profilemanager;

import com.lathia.example.profilemanager.distr.ExampleDistributionActivity;
import com.lathia.example.profilemanager.util.DataGenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final MainListAdapter adapter = new MainListAdapter(this);
		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
			{
				switch (position)
				{
				case 0: // Distribution
					Toast.makeText(MainActivity.this, "Creating fake data...", Toast.LENGTH_SHORT).show();
					showDistribution();
					break;
				case 1: // Events
					break;
				case 2: // Mappings
					break;
				}
			}
		});
	}
	
	private void showDistribution()
	{
		new AsyncTask<Void, Void, Void>()
		{
			@Override
			protected Void doInBackground(Void... arg0)
			{
				DataGenerator.createDistribution(MainActivity.this);
				runOnUiThread(new Runnable()
				{
					@Override
					public void run()
					{
						Intent intent = new Intent(MainActivity.this, ExampleDistributionActivity.class);
						MainActivity.this.startActivity(intent);
					}
				});
				return null;
			}	
		}.execute();
	}

}
