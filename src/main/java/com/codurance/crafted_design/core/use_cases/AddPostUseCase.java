package com.codurance.crafted_design.core.use_cases;

import com.codurance.crafted_design.core.use_cases.domain.user.UserRepository;

public class AddPostUseCase {

	private final UserRepository userRepository;

	public AddPostUseCase(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void addPost(String user, String message) {
		userRepository.createPost(user, message);
	}
}
