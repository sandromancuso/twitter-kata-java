package com.codurance.crafted_design.core.domain;

import java.util.Date;

public class Post {
	private final String userName;
	private final String message;
	private Date dateTime;

	public Post(String userName, String message, Date dateTime) {
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
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Post post = (Post) o;

		return message.equals(post.message) && userName.equals(post.userName);
	}

	@Override
	public int hashCode() {
		int result = userName.hashCode();
		result = 31 * result + message.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Post{" +
				"userName='" + userName + '\'' +
				", message='" + message + '\'' +
				", dateTime=" + dateTime +
				'}';
	}

	public Date date() {
		return dateTime;
	}
}
