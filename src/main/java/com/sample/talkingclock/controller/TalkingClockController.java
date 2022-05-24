package com.sample.talkingclock.controller;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.talkingclock.service.TalkingClockService;

import io.swagger.annotations.Api;

@Api(value = "Talking Clock Controller", description = "REST API for talking clock")
@RestController
@RequestMapping("/api/clock")
public class TalkingClockController {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	TalkingClockService talkingClockService;
	
	/**
	 * Controller to get request to convert current time to word
	 * 
	 * @return {@link ResponseEntity}
	 */
	@GetMapping("/currentTime")
	public ResponseEntity<String> getCurrentTime(){
		logger.info("Getting current time in words");
		Calendar now = Calendar.getInstance();
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minutes = now.get(Calendar.MINUTE);
		
		String time = talkingClockService.convertTimeToWord(hour, minutes);
		
		return ResponseEntity.ok().body(time);
	}
	
	/**
	 * Controller to get request to convert a custom time to word
	 * 
	 * @param hour
	 * @param minutes
	 * @return {@link ResponseEntity}
	 */
	@GetMapping("/customTime")
	public ResponseEntity<String> getCustomTimeInWords(@RequestParam Integer hour, @RequestParam Integer minutes){
		logger.info("Getting custom time in words");
		String time = talkingClockService.convertTimeToWord(hour, minutes);
		return ResponseEntity.ok().body(time);
	}
}
