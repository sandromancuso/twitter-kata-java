package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.domain.UserRepository;
import com.codurance.crafted_design.view.Console;

public class WallCommand implements Command {

	private static final String WALL_COMMAND = " wall";

	private UserRepository userRepository;
	private final String userCommand;
	private final Console console;

	public WallCommand(UserRepository userRepository,
	                   Console console,
	                   String userCommand) {
		this.userRepository = userRepository;
		this.console = console;
		this.userCommand = userCommand;
	}

	@Override
	public void execute() {
		String userName = userCommand.replaceAll(WALL_COMMAND, "");
		console.write(userRepository.wallPostsFor(userName));
	}
}
