package com.sample.talkingclock.service.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sample.talkingclock.exception.BusinessExceptionFactory;
import com.sample.talkingclock.service.TalkingClockService;

@Service
public class TalkingClockServiceImpl implements TalkingClockService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public String convertTimeToWord(int hour, int minutes) {
		logger.info("Present Hour:Minute :: {}:{}", hour, minutes);
		validateRequest(hour, minutes);
		return convertionCalculation(hour, minutes);
	}
	
	private void validateRequest(int hour, int minutes) {
		logger.info("Validating parameters");
		if(hour<0 || hour>23) {
			throw BusinessExceptionFactory.invalidHourRange();
		}
		if(minutes<0 || minutes>59) {
			throw BusinessExceptionFactory.invalidMinuteRange();
		}
	}

	private String convertionCalculation(int hour, int minutes) {
		String result;
		if (hour == 12 && minutes == 0) {
			result = "It's Midday";
		} else if (hour == 0 && minutes == 0) {
			result = "It's Midnight";
		} else {
			result = "It's ";
			HashMap<Integer, String> map = new HashMap<Integer, String>();
			map.put(1, "one ");
			map.put(2, "two ");
			map.put(3, "three ");
			map.put(4, "four ");
			map.put(5, "five ");
			map.put(6, "six ");
			map.put(7, "seven ");
			map.put(8, "eight ");
			map.put(9, "nine ");
			map.put(10, "ten ");
			map.put(11, "eleven ");
			map.put(12, "twelve ");
			map.put(13, "thirteen ");
			map.put(14, "fourteen ");
			map.put(15, "fifteen ");
			map.put(16, "sixteen ");
			map.put(17, "seventeen ");
			map.put(18, "eighteen ");
			map.put(19, "nineteen ");
			map.put(20, "twenty ");
			map.put(30, "thirty ");
			map.put(40, "fourty ");
			map.put(50, "fifty ");

			if (hour > 20) {
				int p2 = hour % 10;
				int p1 = hour - p2;

				result = result + map.get(p1) + map.get(p2);
				logger.info("p1 : {} & p2 : {}", p1, p2);
			} else {
				result = result + map.get(hour);
			}

			if (minutes < 20) {
				result = result + map.get(minutes);
			} else {
				int m2 = minutes % 10;
				if (m2 == 0) {
					result = result + map.get(minutes);
				} else {
					int m1 = minutes - m2;
					result = result + map.get(m1) + map.get(m2);
				}
			}
		}

		return result.trim();
	}

}
