package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.use_cases.AddPostUseCase;

public class CommandFactory {

	private final AddPostUseCase addPostUseCase;

	public CommandFactory(AddPostUseCase addPostUseCase) {
		this.addPostUseCase = addPostUseCase;
	}

	public Command create(String userCommand) {
		return new PostCommand(addPostUseCase, userCommand);
	}
}
