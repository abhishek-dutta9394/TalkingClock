package com.sample.talkingclock.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sample.talkingclock.service.TalkingClockService;

@SpringBootTest
public class TalkingClockControllerTest {
	
	@InjectMocks
	TalkingClockController controller;
	
	@Mock
	TalkingClockService talkingClockService;
	
	@Test
	void testGetCurrentTime() {
		String time = "It's eight thirty four"; 
		when(talkingClockService.convertTimeToWord(8, 34)).thenReturn(time);
		ResponseEntity<String> response = controller.getCurrentTime();
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	void testGetCustomTimeInWords() {
		int hour = 8;
		int minutes = 34;
		String time = "It's eight thirty four";
		when(talkingClockService.convertTimeToWord(8, 34)).thenReturn(time);
		ResponseEntity<String> response = controller.getCustomTimeInWords(hour, minutes);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(time, response.getBody());
	}
}
