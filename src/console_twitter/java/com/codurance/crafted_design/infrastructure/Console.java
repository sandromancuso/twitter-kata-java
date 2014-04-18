package com.codurance.crafted_design.infrastructure;

import java.util.Scanner;

public class Console {

	private static final String PROMT = "> ";
	private final Scanner scanner;

	public Console() {
		scanner = new Scanner(System.in);
	}

	public String readline() {
		System.out.print(PROMT);
		return scanner.nextLine();
	}

	public void write(String output) {
		System.out.println(output);
	}

}
