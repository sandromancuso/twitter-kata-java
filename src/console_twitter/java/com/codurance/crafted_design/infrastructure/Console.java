package com.codurance.crafted_design.infrastructure;

import java.util.Scanner;

public class Console {

	private final Scanner scanner;

	public Console() {
		scanner = new Scanner(System.in);
	}

	public String readline() {
		return scanner.nextLine();
	}

	public void write(String output) {
		System.out.println(output);
	}

}
