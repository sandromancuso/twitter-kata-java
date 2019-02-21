package console_twitter.com.codurance.crafted_design.acceptance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.codurance.crafted_design.view.Console.PROMPT;

public class TwitterConsoleTestingDSL {

	public static TwitterConsoleTestingDSL start() {
		return new TwitterConsoleTestingDSL();
	}

	public void receives(String userCommand) {
		userCommands.add(userCommand + "\n");
	}

	public String output() {
		try {
			return runTwitterConsoleWith(userCommands);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String runTwitterConsoleWith(List<String> userCommands) throws IOException {
		Process process = execute(TWITTER_CONSOLE_ON_COMMAND_LINE);

		sendUserCommandsToProcess(userCommands, process);

		return removePrompt(readOutputFrom(process));
	}

	private String readOutputFrom(Process process) throws IOException {
		processReader = reader(process);
		String outputLine;
		StringBuilder output = new StringBuilder();
		while ((outputLine = processReader.readLine()) != null) {
			output.append(outputLine);
		}
		return output.toString();
	}

	private void sendUserCommandsToProcess(List<String> userCommands, Process process) {
		addExitCommandTo(userCommands);
		PrintWriter processWriter = writer(process);
		for(String userCommand: userCommands) {
			processWriter.write(userCommand);
			processWriter.flush();
		}
	}
	private String removePrompt(String output) {
		return output.replaceAll(PROMPT, "");
	}


	private void addExitCommandTo(List<String> userCommands) {
		if (!userCommands.contains(EXIT_COMMAND)) {
			userCommands.add(EXIT_COMMAND);
		}
	}

	private PrintWriter writer(Process process) {
		return new PrintWriter( process.getOutputStream() );
	}

	private BufferedReader reader(Process process) {
		return new BufferedReader( new InputStreamReader(process.getInputStream()) );
	}

	private Process execute(String command) throws IOException {
		return Runtime.getRuntime().exec(command);
	}

	private List<String> userCommands = new ArrayList<>();

	private static final String EXIT_COMMAND = "exit" + "\n";
	private static BufferedReader processReader;

	private static String TWITTER_CONSOLE_ON_COMMAND_LINE =
							"/usr/bin/java -cp ./target/classes " +
							"com.codurance.crafted_design.Twitter";

}
