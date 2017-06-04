package com.codurance.crafted_design.core.use_cases;

import com.codurance.crafted_design.core.domain.UserRepository;

public class FollowUseCase {
	private final UserRepository userRepository;

	public FollowUseCase(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void follow(String followee, String follower) {
		userRepository.addFollower(followee, follower);
	}
}
