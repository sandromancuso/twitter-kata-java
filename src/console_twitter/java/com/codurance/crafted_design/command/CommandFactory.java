package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.use_cases.AddPostUseCase;
import com.codurance.crafted_design.core.use_cases.FollowUseCase;
import com.codurance.crafted_design.core.use_cases.ReadPostsUseCase;
import com.codurance.crafted_design.core.use_cases.WallUseCase;
import com.codurance.crafted_design.view.Console;

import static java.util.regex.Pattern.matches;

public class CommandFactory {

	private final AddPostUseCase addPostUseCase;
	private final FollowUseCase followUseCase;
	private final ReadPostsUseCase readPostUseCase;
	private final WallUseCase wallUseCase;
	private final Console console;

	private static final String POST_COMMAND_PATTERN = "(.*)\\s->\\s(.*)";
	private static final String FOLLOW_COMMAND_PATTERN = "(.*)\\sfollows\\s(.*)";
	private static final String WALL_COMMAND_PATTERN = "(.*)\\swall";

	public CommandFactory(AddPostUseCase addPostUseCase,
	                      ReadPostsUseCase readPostsUseCase,
	                      FollowUseCase followUseCase,
	                      WallUseCase wallUseCase,
	                      Console console) {
		this.addPostUseCase = addPostUseCase;
		this.readPostUseCase = readPostsUseCase;
		this.followUseCase = followUseCase;
		this.wallUseCase = wallUseCase;
		this.console = console;
	}

	public Command create(String userCommand) {
		if (matches(POST_COMMAND_PATTERN, userCommand)) {
			return new PostCommand(addPostUseCase, userCommand);
		} else if (matches(FOLLOW_COMMAND_PATTERN, userCommand)) {
			return new FollowCommand(followUseCase, userCommand);
		} else if (matches(WALL_COMMAND_PATTERN, userCommand)) {
			return new WallCommand(wallUseCase, console, userCommand);
		} else {
			return new ReadCommand(readPostUseCase, console, userCommand);
		}
	}
}
