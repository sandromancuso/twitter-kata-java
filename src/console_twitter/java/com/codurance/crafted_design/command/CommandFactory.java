package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.use_cases.AddPostUseCase;
import com.codurance.crafted_design.core.use_cases.ReadPostsUseCase;

import java.util.regex.Pattern;

public class CommandFactory {

	private final AddPostUseCase addPostUseCase;
	private final ReadPostsUseCase readPostUseCase;

	private static final String POST_COMMAND_PATTERN = "(.*) -> (.*)";

	public CommandFactory(AddPostUseCase addPostUseCase,
	                      ReadPostsUseCase readPostsUseCase) {
		this.addPostUseCase = addPostUseCase;
		this.readPostUseCase = readPostsUseCase;
	}

	public Command create(String userCommand) {
		if (Pattern.matches(POST_COMMAND_PATTERN, userCommand)) {
			return new PostCommand(addPostUseCase, userCommand);
		} else {
			return new ReadCommand();
		}
	}
}
