package com.sample.talkingclock.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.talkingclock.exception.BusinessException;

@SpringBootTest
public class TalkingClockServiceImplTest {
	
	@InjectMocks
	TalkingClockServiceImpl serviceImpl;
	
	@Test
	void testConvertTimeToWord() {
		int hour = 8;
		int minutes = 34;
		String expected = "It's eight thirty four";
		String response = serviceImpl.convertTimeToWord(hour, minutes);
		assertEquals(expected, response);
	}
	
	@Test
	void testConvertTimeToWordLessThanTwentyMinutes() {
		int hour = 8;
		int minutes = 18;
		String expected = "It's eight eighteen";
		String response = serviceImpl.convertTimeToWord(hour, minutes);
		assertEquals(expected, response);
	}
	
	@Test
	void testConvertTimeToWordMidday() {
		int hour = 12;
		int minutes = 00;
		String expected = "It's Midday";
		String response = serviceImpl.convertTimeToWord(hour, minutes);
		assertEquals(expected, response);
	}
	
	@Test
	void testConvertTimeToWordMidnight() {
		int hour = 00;
		int minutes = 00;
		String expected = "It's Midnight";
		String response = serviceImpl.convertTimeToWord(hour, minutes);
		assertEquals(expected, response);
	}
	
	@Test
	void testConvertTimeToWordWholeMinute() {
		int hour = 22;
		int minutes = 40;
		String expected = "It's twenty two fourty";
		String response = serviceImpl.convertTimeToWord(hour, minutes);
		assertEquals(expected, response);
	}
	
	@Test
	void testConvertTimeToWordHourRangeException() {
		int hour = 27;
		int minutes = 40;
		Assertions.assertThrows(BusinessException.class, () -> serviceImpl.convertTimeToWord(hour, minutes));
	}
	
	@Test
	void testConvertTimeToWordLowHourRangeException() {
		int hour = -2;
		int minutes = 40;
		Assertions.assertThrows(BusinessException.class, () -> serviceImpl.convertTimeToWord(hour, minutes));
	}
	
	@Test
	void testConvertTimeToWordMinuteRangeException() {
		int hour = 10;
		int minutes = 67;
		Assertions.assertThrows(BusinessException.class, () -> serviceImpl.convertTimeToWord(hour, minutes));
	}
	
	@Test
	void testConvertTimeToWordLowMinuteRangeException() {
		int hour = 10;
		int minutes = -45;
		Assertions.assertThrows(BusinessException.class, () -> serviceImpl.convertTimeToWord(hour, minutes));
	} 
}
