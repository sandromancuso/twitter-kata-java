package com.codurance.crafted_design.core.use_cases;

import com.codurance.crafted_design.core.domain.Post;
import com.codurance.crafted_design.core.domain.UserRepository;

import java.util.List;

public class WallUseCase {

	private final UserRepository userRepository;

	public WallUseCase(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<Post> wallPostsFor(String userName) {
		return userRepository.wallPostsFor(userName);
	}
}
