package com.codurance.crafted_design.command;

public class CommandExecutor {

	private final CommandFactory commandFactory;

	public CommandExecutor(CommandFactory commandFactory) {
	  	this.commandFactory = commandFactory;
	}

	public void execute(String userCommand) {
		commandFactory.create(userCommand).execute();
	}
}
