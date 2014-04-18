package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.use_cases.AddPostUseCase;
import com.codurance.crafted_design.core.use_cases.ReadPostsUseCase;
import com.codurance.crafted_design.infrastructure.Console;

import java.util.regex.Pattern;

public class CommandFactory {

	private final AddPostUseCase addPostUseCase;
	private final ReadPostsUseCase readPostUseCase;
	private final Console console;

	private static final String POST_COMMAND_PATTERN = "(.*)\\s->\\s(.*)";

	public CommandFactory(AddPostUseCase addPostUseCase,
	                      ReadPostsUseCase readPostsUseCase,
	                      Console console) {
		this.addPostUseCase = addPostUseCase;
		this.readPostUseCase = readPostsUseCase;
		this.console = console;
	}

	public Command create(String userCommand) {
		if (Pattern.matches(POST_COMMAND_PATTERN, userCommand)) {
			return new PostCommand(addPostUseCase, userCommand);
		} else {
			return new ReadCommand(readPostUseCase, console, userCommand);
		}
	}
}