package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.use_cases.FollowUseCase;

public class FollowCommand implements Command {

	private static final String FOLLOW_COMMAND = " follows ";

	private final FollowUseCase followUseCase;
	private final String userCommand;

	public FollowCommand(FollowUseCase followUseCase, String userCommand) {
		this.followUseCase = followUseCase;
		this.userCommand = userCommand;
	}

	@Override
	public void execute() {
		String[] userAndMessage = userCommand.split(FOLLOW_COMMAND);
		String followee = userAndMessage[0];
		String follower = userAndMessage[1];
		followUseCase.follow(followee, follower);
	}

}
