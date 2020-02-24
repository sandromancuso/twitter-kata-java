package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.domain.UserRepository;

public class FollowCommand implements Command {

	private static final String FOLLOW_COMMAND = " follows ";

	private UserRepository userRepository;
	private final String userCommand;

	public FollowCommand(UserRepository userRepository, String userCommand) {
		this.userRepository = userRepository;
		this.userCommand = userCommand;
	}

	@Override
	public void execute() {
		String[] userAndMessage = userCommand.split(FOLLOW_COMMAND);
		String follower = userAndMessage[0];
		String followee = userAndMessage[1];
		userRepository.addFollower(followee, follower);
	}

}
