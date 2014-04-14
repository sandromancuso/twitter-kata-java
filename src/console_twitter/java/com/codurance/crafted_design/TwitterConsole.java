package com.codurance.crafted_design;

import com.codurance.crafted_design.infrastructure.Console;

public class TwitterConsole {

	private final Console console;

	public TwitterConsole(Console console) {
		this.console = console;
	}

	public void start() {
		String userCommand = console.readline();
		while(!userCommand.equals("exit")) {
			userCommand = console.readline();
		}
		console.write("bye!");
	}

	public static void main(String[] args) {
		Console console = new Console();
		TwitterConsole twitter = new TwitterConsole(console);

		twitter.start();
	}

}
