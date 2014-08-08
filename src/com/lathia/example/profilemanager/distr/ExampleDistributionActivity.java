package com.lathia.example.profilemanager.distr;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lathia.example.profilemanager.R;
import com.lathia.example.profilemanager.util.DataGenerator;
import com.ubhave.profilemanager.data.Distribution;
import com.ubhave.profilemanager.ui.distribution.DistributionActivity;
import com.ubhave.profilemanager.ui.distribution.DistributionListAdapter;

public class ExampleDistributionActivity extends DistributionActivity
{

	@Override
	protected String getDistributionVariableName()
	{
		// This is the distribution group name that is used when storing data
		// to/
		// querying data from the Profile Manager
		return DataGenerator.FRUITS;
	}

	@Override
	protected void onNoDataAvailable()
	{
		// What should your activity do if the distribution is empty?
		// In this example, it toasts a 'no data' message and finishes

		Toast.makeText(this, "No data!", Toast.LENGTH_SHORT).show();
		finish();
	}

	@Override
	protected View getNoDataView()
	{
		// What should your activity display if the distribution is empty?
		// Return the view that you want set to visible if there is no data and
		// invisible otherwise
		// Null in this example app (the activity finishes on no data)

		return null;
	}

	/*
	 * The following are the UI components that the library uses.
	 */

	@Override
	protected int getLayoutId()
	{
		// The layout Id is the argument for setContentView()
		return R.layout.activity_distribution;
	}

	/*
	 * Distribution title
	 */

	@Override
	protected TextView getScreenTitleView()
	{
		// This is the text view UI component which is your distribution's title
		// The abstract view sets the value of this to whatever you return from
		// getDistributionTitle()
		return (TextView) findViewById(R.id.screen_title);
	}

	@Override
	protected String getScreenTitleValue()
	{
		// This string is the value that is set to the text view returned by
		// getScreenTitle()
		return "Fruit Consumption";
	}

	/*
	 * Distribution UI
	 */

	@Override
	protected ListView getListView()
	{
		// The list view that shows your distribution
		return (ListView) findViewById(R.id.listView);
	}

	@Override
	protected DistributionListAdapter getAdapter(final Distribution distribution)
	{
		// The adapter that will be used to display your distribution
		// This adapter will be used with setAdapter() on the return value of
		// getListView()
		return new ExampleDistributionAdapter(this, distribution);
	}

	@Override
	protected ProgressBar getLoadingProgressBar()
	{
		// The progress bar that you want set to visible while the distribution
		// is asynchronously loading
		return (ProgressBar) findViewById(R.id.loading_progress);
	}

}
