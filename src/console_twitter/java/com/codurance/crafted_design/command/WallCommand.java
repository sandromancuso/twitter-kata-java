package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.use_cases.WallUseCase;
import com.codurance.crafted_design.view.Console;

public class WallCommand implements Command {

	private static final String WALL_COMMAND = " wall";

	private final WallUseCase wallUseCase;
	private final String userCommand;
	private final Console console;

	public WallCommand(WallUseCase wallUseCase, Console console, String userCommand) {
		this.wallUseCase = wallUseCase;
		this.console = console;
		this.userCommand = userCommand;
	}

	@Override
	public void execute() {
		String userName = userCommand.replaceAll(WALL_COMMAND, "");
		console.write(wallUseCase.wallPostsFor(userName));
	}
}
