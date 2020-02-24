package com.codurance.crafted_design.core.domain;

import java.util.*;

public class UserRepository {

	private static final List<Post> NO_POSTS = new ArrayList<>();
	private static final Map<String, User> users = new HashMap<>();
	public static final int HEAD = 0;
	private final Clock clock;

	private Map<String, List<Post>> posts = new HashMap<>();

	public UserRepository(Clock clock) {
		this.clock = clock;
	}

	public void addPost(String userName, String postMessage) {
		List<Post> posts = postsFor(userName);
		posts.add(HEAD, new Post(userName, postMessage, clock.now()));
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
		User user = userFor(followee);
		User followerUser = userFor(follower);
		followerUser.follows(user);
	}

	public List<Post> wallPostsFor(String userName) {
		User user = userFor(userName);
	    List<Post> wallPosts = postsBy(userName);
		wallPosts.addAll(postsFrom(user.followingUsers()));
		wallPosts.sort(byDate());
		return wallPosts;
	}

	private List<Post> postsFrom(Collection<User> users) {
		List<Post> allPosts = new ArrayList<>();
		for (User user : users) {
			allPosts.addAll(postsBy(user.userName()));
		}
		return allPosts;
	}

	private User userFor(String userName) {
		User user = users.getOrDefault(userName, new User(userName));
		users.put(userName, user);
		return user;
	}

	private Comparator<Post> byDate() {
		return new Comparator<Post>() {
			@Override
			public int compare(Post p1, Post p2) {
				return p1.dateTime().isAfter(p2.dateTime()) ? -1 : 1;
			}
		};
	}

}
