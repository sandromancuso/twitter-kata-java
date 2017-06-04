package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.use_cases.AddPostUseCase;

public class PostCommand implements Command {

	private static final String POST_COMMAND = " -> ";
	private final String userCommand;
	private final AddPostUseCase addPostUseCase;

	public PostCommand(AddPostUseCase addPostUseCase, String userCommand) {
		this.addPostUseCase = addPostUseCase;
		this.userCommand = userCommand;
	}

	@Override
	public void execute() {
		String[] userAndMessage = userCommand.split(POST_COMMAND);
		String user = userAndMessage[0];
		String message = userAndMessage[1];
		addPostUseCase.addPost(user, message);
	}
}
