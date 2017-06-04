package com.codurance.crafted_design.core.domain;

import java.util.*;

public class User {
	private final String userName;

	private Set<User> following = new HashSet<>();

	public User(String userName) {
		this.userName = userName;
	}

	public void follows(User user) {
		following.add(user);
	}

	public Set<User> followingUsers() {
		return Collections.unmodifiableSet(following);
	}

	public String userName() {
		return this.userName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (!following.equals(user.following)) return false;
		if (!userName.equals(user.userName)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = userName.hashCode();
		result = 31 * result + following.hashCode();
		return result;
	}
}
