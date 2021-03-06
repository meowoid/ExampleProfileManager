/* **************************************************
 Copyright (c) 2014, University of Cambridge
 Neal Lathia, neal.lathia@cl.cam.ac.uk
 ************************************************** */

package com.lathia.example.profilemanager.events;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lathia.example.profilemanager.R;
import com.ubhave.profilemanager.data.Distribution;
import com.ubhave.profilemanager.ui.events.EventListAdapter;

public class ExampleEventAdapter extends EventListAdapter
{

	public ExampleEventAdapter(Context context, Distribution data)
	{
		super(context, data, R.layout.list_item_distribution);
	}

	@Override
	protected TextView getEntryText(View row)
	{
		return (TextView) row.findViewById(R.id.entryText);
	}

	@Override
	protected TextView getLabelTextView(View row)
	{
		return (TextView) row.findViewById(R.id.percentageText);
	}

	@Override
	protected ProgressBar getEntryProgressBar(View row)
	{
		return (ProgressBar) row.findViewById(R.id.entryProgress);
	}
}
