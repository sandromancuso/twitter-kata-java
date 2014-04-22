package com.codurance.crafted_design;

import com.codurance.crafted_design.command.CommandExecutor;
import com.codurance.crafted_design.command.CommandFactory;
import com.codurance.crafted_design.core.use_cases.AddPostUseCase;
import com.codurance.crafted_design.core.domain.UserRepository;
import com.codurance.crafted_design.core.use_cases.FollowUseCase;
import com.codurance.crafted_design.core.use_cases.ReadPostsUseCase;
import com.codurance.crafted_design.view.Console;

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
		while(!EXIT.equals(userCommand)) {
			commandExecutor.execute(userCommand);
			userCommand = console.readline();
		}
		console.write("bye!");
	}

	public static void main(String[] args) {
		twitterConsole().start();
	}

	private static TwitterConsole twitterConsole() {
		UserRepository userRepository = new UserRepository();
		AddPostUseCase addPostUseCase = new AddPostUseCase(userRepository);
		FollowUseCase followUseCase = new FollowUseCase(userRepository);
		ReadPostsUseCase readPostsUseCase = new ReadPostsUseCase(userRepository);

		Console console = new Console();
		CommandFactory commandFactory = new CommandFactory(addPostUseCase,
														   readPostsUseCase,
														   followUseCase,
														   console);
		CommandExecutor commandExecutor = new CommandExecutor(commandFactory);

		return new TwitterConsole(console, commandExecutor);
	}

}
