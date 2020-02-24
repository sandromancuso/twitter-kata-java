package com.codurance.crafted_design.core.domain;

import java.time.LocalDateTime;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class Post {
	private final String userName;
	private final String message;
	private LocalDateTime dateTime;

	public Post(String userName, String message, LocalDateTime dateTime) {
		this.userName = userName;
		this.message = message;
		this.dateTime = dateTime;
	}

	public String username() {
		return this.userName;
	}

	public String message() {
		return this.message;
	}

	@Override
	public boolean equals(Object o) {
		return reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return "Post{" +
				"userName='" + userName + '\'' +
				", message='" + message + '\'' +
				", dateTime=" + dateTime +
				'}';
	}

	public LocalDateTime dateTime() {
		return dateTime;
	}
}
