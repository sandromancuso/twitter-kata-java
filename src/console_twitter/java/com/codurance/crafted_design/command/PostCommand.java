package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.domain.UserRepository;

public class PostCommand implements Command {

	private static final String POST_COMMAND = " -> ";
	private final String userCommand;
	private final UserRepository userRepository;

	public PostCommand(UserRepository userRepository, String userCommand) {
		this.userRepository = userRepository;
		this.userCommand = userCommand;
	}

	@Override
	public void execute() {
		String[] userAndMessage = userCommand.split(POST_COMMAND);
		String user = userAndMessage[0];
		String message = userAndMessage[1];
		userRepository.addPost(user, message);
	}
}
