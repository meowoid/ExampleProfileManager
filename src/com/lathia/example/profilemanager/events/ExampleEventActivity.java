package com.lathia.example.profilemanager.events;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lathia.example.profilemanager.R;
import com.lathia.example.profilemanager.util.DataGenerator;
import com.ubhave.profilemanager.data.Distribution;
import com.ubhave.profilemanager.ui.events.EventListActivity;
import com.ubhave.profilemanager.ui.events.EventListAdapter;

public class ExampleEventActivity extends EventListActivity
{
	/*
	 * UI Content
	 */

	@Override
	protected String getDistributionVariableName()
	{
		return DataGenerator.FRUITS;
	}
	
	/*
	 * What should your activity do if the distribution is empty?
	 */

	@Override
	protected void onNoDataAvailable()
	{	
		// Example usage
		Toast.makeText(this, "No data!", Toast.LENGTH_SHORT).show();
		finish();
	}
	
	@Override
	protected View getNoDataView()
	{
		// None in this example app
		return null;
	}
	
	/*
	 * Create a list adapter from the given distribution
	 */

	@Override
	protected EventListAdapter getAdapter(final Distribution distribution)
	{
		return new ExampleEventAdapter(this, distribution);
	}
	
	/*
	 * The following are the UI components that the library uses.
	 */
	
	@Override
	protected int getLayoutId()
	{
		return R.layout.activity_distribution;
	}

	@Override
	protected ListView getListView()
	{
		return (ListView) findViewById(R.id.listView);
	}

	@Override
	protected ProgressBar getLoadingProgressBar()
	{
		return (ProgressBar) findViewById(R.id.loading_progress);
	}

	@Override
	protected TextView getScreenTitleView()
	{
		return (TextView) findViewById(R.id.screen_title);
	}

	@Override
	protected String getScreenTitleValue()
	{
		return "Fruits";
	}
}
