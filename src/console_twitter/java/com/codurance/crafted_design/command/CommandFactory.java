package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.use_cases.AddPostUseCase;
import com.codurance.crafted_design.core.use_cases.FollowUseCase;
import com.codurance.crafted_design.core.use_cases.ReadPostsUseCase;
import com.codurance.crafted_design.view.Console;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.matches;

public class CommandFactory {

	private final AddPostUseCase addPostUseCase;
	private final FollowUseCase followUseCase;
	private final ReadPostsUseCase readPostUseCase;
	private final Console console;

	private static final String POST_COMMAND_PATTERN = "(.*)\\s->\\s(.*)";
	private static final String FOLLOW_COMMAND_PATTERN = "(.*)\\sfollows\\s(.*)";

	public CommandFactory(AddPostUseCase addPostUseCase,
	                      ReadPostsUseCase readPostsUseCase,
	                      FollowUseCase followUseCase,
	                      Console console) {
		this.addPostUseCase = addPostUseCase;
		this.readPostUseCase = readPostsUseCase;
		this.followUseCase = followUseCase;
		this.console = console;
	}

	public Command create(String userCommand) {
		if (matches(POST_COMMAND_PATTERN, userCommand)) {
			return new PostCommand(addPostUseCase, userCommand);
		} else if (matches(FOLLOW_COMMAND_PATTERN, userCommand)) {
			return new FollowCommand(followUseCase, userCommand);
		} else {
			return new ReadCommand(readPostUseCase, console, userCommand);
		}
	}
}
