/* **************************************************
 Copyright (c) 2014, University of Cambridge
 Neal Lathia, neal.lathia@cl.cam.ac.uk
 ************************************************** */

package com.lathia.example.profilemanager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainListAdapter extends ArrayAdapter<String>
{
	private final static String[] ENTRIES = new String[]{"Distribution", "Events", "Mappings"};
	
	public MainListAdapter(Context context)
	{
		super(context, R.layout.list_item);
		addAll(ENTRIES);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View rowView = convertView;
		if (rowView == null)
		{
			rowView = View.inflate(getContext(), R.layout.list_item, null);
		}
		
		String entry = getItem(position);
		TextView textView = (TextView) rowView.findViewById(R.id.entryText);
		textView.setText(entry);
		return rowView;
	}
}
