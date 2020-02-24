package com.codurance.crafted_design.core.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

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
		return reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}
}
