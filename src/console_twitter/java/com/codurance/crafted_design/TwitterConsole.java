package com.codurance.crafted_design;

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
		Console console = new Console();
		CommandExecutor commandExecutor = new CommandExecutor();
		return new TwitterConsole(console, commandExecutor);
	}

}
