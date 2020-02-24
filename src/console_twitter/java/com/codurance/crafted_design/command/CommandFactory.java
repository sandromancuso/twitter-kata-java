package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.domain.UserRepository;
import com.codurance.crafted_design.view.Console;

import static java.util.regex.Pattern.matches;

public class CommandFactory {

	private UserRepository userRepository;
	private final Console console;

	private static final String POST_COMMAND_PATTERN = "(.*)\\s->\\s(.*)";
	private static final String FOLLOW_COMMAND_PATTERN = "(.*)\\sfollows\\s(.*)";
	private static final String WALL_COMMAND_PATTERN = "(.*)\\swall";

	public CommandFactory(UserRepository userRepository,
	                      Console console) {
		this.userRepository = userRepository;
		this.console = console;
	}

	public Command create(String userCommand) {
		if (matches(POST_COMMAND_PATTERN, userCommand)) {
			return new PostCommand(userRepository, userCommand);
		} else if (matches(FOLLOW_COMMAND_PATTERN, userCommand)) {
			return new FollowCommand(userRepository, userCommand);
		} else if (matches(WALL_COMMAND_PATTERN, userCommand)) {
			return new WallCommand(userRepository, console, userCommand);
		} else {
			return new ReadCommand(userRepository, console, userCommand);
		}
	}
}
