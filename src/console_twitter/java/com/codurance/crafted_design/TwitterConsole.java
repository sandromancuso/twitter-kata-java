package com.codurance.crafted_design;

import com.codurance.crafted_design.command.CommandExecutor;
import com.codurance.crafted_design.command.CommandFactory;
import com.codurance.crafted_design.core.use_cases.AddPostUseCase;
import com.codurance.crafted_design.infrastructure.Console;

public class TwitterConsole {

	private static final String EXIT = "exit";
	private final Console console;
	private final CommandExecutor commandExecutor;

	public TwitterConsole(Console console, CommandExecutor commandExecutor) {
		this.console = console;
		this.commandExecutor = commandExecutor;
	}

	public void start() {
		String userCommand = console.readline();
		while(!userCommand.equals(EXIT)) {
			commandExecutor.execute(userCommand);
			userCommand = console.readline();
		}
		console.write("bye!");
	}

	public static void main(String[] args) {
		twitterConsole().start();
	}

	private static TwitterConsole twitterConsole() {
		AddPostUseCase addPostUseCase = new AddPostUseCase();

		Console console = new Console();
		CommandFactory commandFactory = new CommandFactory(addPostUseCase);
		CommandExecutor commandExecutor = new CommandExecutor(commandFactory);

		return new TwitterConsole(console, commandExecutor);
	}

}
