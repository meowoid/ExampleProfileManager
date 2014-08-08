package com.lathia.example.profilemanager.util;

import java.util.HashMap;
import java.util.Random;

import android.content.Context;

import com.ubhave.profilemanager.ProfileDataStore;

public class DataGenerator
{
	public final static String EVENTS = "Events";
	public final static String FRUITS = "Fruit";
	public final static String FEELINGS = "Feeling";

	private final static String[] FRUIT_TYPES = new String[] { "Apple", "Pear", "Banana", "Mango" };
	private final static String[] FEELING_TYPES = new String[] { "Happy", "Sad", "Calm", "Anxious" };

	public static void createDistribution(final Context context)
	{
		// Get the instance
		ProfileDataStore profileManager = ProfileDataStore.getInstance(context);

		// Remove old data
		if (profileManager.containsDistribution(FRUITS))
		{
			profileManager.removeDistributionTable(FRUITS);
		}

		// Create new random data
		Random random = new Random();
		for (String fruit : FRUIT_TYPES)
		{
			int frequency = random.nextInt(100);
			profileManager.addToDistribution(FRUITS, fruit, frequency);
		}
	}

	public static void createEvents(final Context context)
	{
		// Get the instance
		ProfileDataStore profileManager = ProfileDataStore.getInstance(context);

		// Remove old data
		if (profileManager.containsEventGroup(EVENTS))
		{
			profileManager.removeEventGroup(EVENTS);
		}

		// Create new random data
		int maxDaysInPast = 7;
		long now = System.currentTimeMillis();
		long oneDay = (1000L * 60 * 60 * 24);
		
		Random random = new Random();
		for (int i = 0; i < 100; i++)
		{
			HashMap<String, String> event = new HashMap<String, String>();
			event.put(FEELINGS, FEELING_TYPES[random.nextInt(FEELING_TYPES.length)]);
			event.put(FRUITS, FRUIT_TYPES[random.nextInt(FRUIT_TYPES.length)]);
			int daysInPast = random.nextInt(maxDaysInPast);
			
			profileManager.addEvent(EVENTS, now - (oneDay * daysInPast), event);
		}
	}

}
