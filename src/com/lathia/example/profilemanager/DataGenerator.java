package com.lathia.example.profilemanager;

import java.util.Random;

import android.content.Context;

import com.ubhave.profilemanager.ProfileDataStore;

public class DataGenerator
{
	public final static String FRUIT_DISTRIBUTION = "Fruits";
	
	private final static String[] FRUITS = new String[]{
		"Apple",
		"Pear",
		"Banana",
		"Mango"
	};
	
	public static void createDistribution(final Context context)
	{
		ProfileDataStore profileManager = ProfileDataStore.getInstance(context);
		
		if (profileManager.containsDistributionVariable(FRUIT_DISTRIBUTION))
		{
			profileManager.removeDistributionTable(FRUIT_DISTRIBUTION);
		}
		
		Random random = new Random();
		for (String fruit : FRUITS)
		{
			int frequency = random.nextInt(100);
			profileManager.addToDistribution(FRUIT_DISTRIBUTION, fruit, frequency);
		}
	}
	
	
}
