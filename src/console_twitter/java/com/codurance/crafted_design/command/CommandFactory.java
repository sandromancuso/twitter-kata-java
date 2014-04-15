package com.codurance.crafted_design.command;

public class CommandFactory {
	public Command create(String userCommand) {
		return new PostCommand();
	}
}
