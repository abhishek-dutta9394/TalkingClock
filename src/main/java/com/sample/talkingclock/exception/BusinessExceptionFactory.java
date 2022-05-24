package com.sample.talkingclock.exception;

import com.sample.talkingclock.common.ErrorCodes;

public class BusinessExceptionFactory {

	public static BusinessException invalidHourRange() {
		return new BusinessException(ErrorCodes.INVALID_HOUR_RANGE.value(), ErrorCodes.INVALID_HOUR_RANGE.getReason(),
				ErrorCodes.INVALID_HOUR_RANGE.getDescription());
	}
	
	public static BusinessException invalidMinuteRange() {
		return new BusinessException(ErrorCodes.INVALID_MINUTES_RANGE.value(), ErrorCodes.INVALID_MINUTES_RANGE.getReason(), 
				ErrorCodes.INVALID_MINUTES_RANGE.getDescription());
	}
}
