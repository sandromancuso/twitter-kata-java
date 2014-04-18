package com.codurance.crafted_design.core.domain;

public class Post {
	private final String userName;
	private final String message;

	public Post(String userName, String message) {
		this.userName = userName;
		this.message = message;
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
		return "username: " + userName + " | message: " + message;
	}
}
