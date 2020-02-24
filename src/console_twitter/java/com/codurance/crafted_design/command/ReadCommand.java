package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.domain.UserRepository;
import com.codurance.crafted_design.view.Console;

public class ReadCommand implements Command {

	private final UserRepository userRepository;
	private final String userName;
	private final Console console;

	public ReadCommand(UserRepository userRepository, Console console, String userName) {
 	    this.userRepository = userRepository;
		this.console = console;
		this.userName = userName;
	}

	@Override
	public void execute() {
		console.write(userRepository.postsBy(userName));
	}
}
