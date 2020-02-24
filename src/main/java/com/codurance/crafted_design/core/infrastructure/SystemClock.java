package com.codurance.crafted_design.core.infrastructure;

import com.codurance.crafted_design.core.domain.Clock;

import java.time.LocalDateTime;

public class SystemClock implements Clock {

	@Override
	public LocalDateTime now() {
		return LocalDateTime.now();
	}
}
