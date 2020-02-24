package com.codurance.crafted_design;

import com.codurance.crafted_design.command.CommandExecutor;
import com.codurance.crafted_design.command.CommandFactory;
import com.codurance.crafted_design.core.domain.Clock;
import com.codurance.crafted_design.core.domain.UserRepository;
import com.codurance.crafted_design.core.infrastructure.SystemClock;
import com.codurance.crafted_design.view.Console;

public class Twitter {

	private static final String EXIT = "exit";
	private final Console console;
	private final CommandExecutor commandExecutor;

	public Twitter(Console console, CommandExecutor commandExecutor) {
		this.console = console;
		this.commandExecutor = commandExecutor;
	}

	public void start() {
		String userCommand = console.readline();
		while(!EXIT.equals(userCommand)) {
			commandExecutor.execute(userCommand);
			userCommand = console.readline();
		}
		console.write("bye!");
	}

	public static void main(String[] args) {
		twitterConsole().start();
	}

	private static Twitter twitterConsole() {
		Clock clock = new SystemClock();
		UserRepository userRepository = new UserRepository(clock);
		Console console = new Console();
		CommandFactory commandFactory = new CommandFactory(userRepository, console);
		CommandExecutor commandExecutor = new CommandExecutor(commandFactory);

		return new Twitter(console, commandExecutor);
	}

}
