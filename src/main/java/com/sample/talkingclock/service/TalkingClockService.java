package com.sample.talkingclock.service;

/**
 * @author abhisdut
 *
 */
public interface TalkingClockService {

	/**
	 * This method is to convert time to words
	 * 
	 * @param hour
	 * @param minutes
	 * @return {@link String}
	 */
	public String convertTimeToWord(int hour, int minutes);
	
}
