package me.rahul.commons;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomNumberGenerator {
	
	private static final Logger logger = LogManager.getLogger(RandomNumberGenerator.class);

	public int[] generateRandomNumber(int num, long range)	{
		logger.info("Generate random numbers");
		
		// create instance of Random class
		Random rand = new Random();

		// Generate random integers in range 0 to 1000
		int[] arr = new int[num];
		for (int i=0; i<num; i++) {
			arr[i] = rand.nextInt((int) range);
		}

		// return
		return arr;
	}
}
