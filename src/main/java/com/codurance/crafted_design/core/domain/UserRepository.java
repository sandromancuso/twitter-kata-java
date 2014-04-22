package com.codurance.crafted_design.core.domain;

import java.util.*;

public class UserRepository {

	private static final List<Post> NO_POSTS = new ArrayList<>();
	public static final int HEAD = 0;

	private Map<String, List<Post>> posts = new HashMap<>();

	public void createPost(String userName, String postMessage) {
		List<Post> posts = postsFor(userName);
		posts.add(HEAD, new Post(userName, postMessage));
	}

	public List<Post> postsBy(String userName) {
		return posts.getOrDefault(userName, NO_POSTS);
	}

	private List<Post> postsFor(String userName) {
		if (!posts.containsKey(userName)) {
			posts.put(userName, new ArrayList<>());
		}
		return posts.get(userName);
	}

	public void addFollower(String followee, String follower) {
	}
}
