package com.lathia.example.profilemanager;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ubhave.profilemanager.data.Distribution;
import com.ubhave.profilemanager.ui.distribution.DistributionActivity;
import com.ubhave.profilemanager.ui.distribution.DistributionListAdapter;

public class ExampleDistributionActivity extends DistributionActivity
{
	/*
	 * UI Content
	 */

	@Override
	protected String getDistributionTitle()
	{
		return "Fruits";
	}

	@Override
	protected String getDistributionVariableName()
	{
		return DataGenerator.FRUIT_DISTRIBUTION;
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
	protected DistributionListAdapter getAdapter(final Distribution distribution)
	{
		return new ExampleDistributionAdapter(this, distribution);
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
	protected TextView getScreenTitle()
	{
		return (TextView) findViewById(R.id.screen_title);
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
}
