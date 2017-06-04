package com.codurance.crafted_design.core.infrastructure;

import com.codurance.crafted_design.core.domain.Clock;

import java.util.Date;

public class SystemClock implements Clock {

	@Override
	public Date now() {
		return new Date();
	}
}
