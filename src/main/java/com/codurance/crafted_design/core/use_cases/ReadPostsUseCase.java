package com.codurance.crafted_design.core.use_cases;

import com.codurance.crafted_design.core.domain.Post;
import com.codurance.crafted_design.core.domain.UserRepository;

import java.util.List;

public class ReadPostsUseCase {
	private final UserRepository userRepository;

	public ReadPostsUseCase(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<Post> postsBy(String userName) {
		return userRepository.postsBy(userName);
	}
}
