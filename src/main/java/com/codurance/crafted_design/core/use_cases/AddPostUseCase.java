package com.codurance.crafted_design.core.use_cases;

import com.codurance.crafted_design.core.domain.UserRepository;

public class AddPostUseCase {

	private final UserRepository userRepository;

	public AddPostUseCase(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void addPost(String user, String message) {
		userRepository.addPost(user, message);
	}
}
