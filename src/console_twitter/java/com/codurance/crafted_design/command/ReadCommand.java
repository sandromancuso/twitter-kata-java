package com.codurance.crafted_design.command;

import com.codurance.crafted_design.core.use_cases.ReadPostsUseCase;
import com.codurance.crafted_design.infrastructure.Console;

public class ReadCommand implements Command {

	private final ReadPostsUseCase readPostsUseCase;
	private final String userName;
	private final Console console;

	public ReadCommand(ReadPostsUseCase readPostsUseCase, Console console, String userName) {
 	    this.readPostsUseCase = readPostsUseCase;
		this.console = console;
		this.userName = userName;
	}

	@Override
	public void execute() {
		console.write(readPostsUseCase.postsBy(userName));
	}
}
