package console_twitter.com.codurance.crafted_design.acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartAndStopStepdefs {

	private TwitterConsoleTestingDSL twitterConsoleTestingDSL;

	@Given("^the application receives an 'exit' command$")
	public void the_application_receives_an_exit_command() throws Throwable {
		twitterConsoleTestingDSL = TwitterConsoleTestingDSL.start();
		twitterConsoleTestingDSL.receives("blah command");
		twitterConsoleTestingDSL.receives("exit");
	}

	@Then("^the application should terminate$")
	public void the_application_should_terminate() throws Throwable {
		String output = twitterConsoleTestingDSL.output();
		assertThat(output, is("bye!"));
	}

	static public class TwitterConsoleTestingDSL {

		private List<String> userCommands = new ArrayList<>();

		public static TwitterConsoleTestingDSL start() {
			return new TwitterConsoleTestingDSL();
		}

		public void receives(String userCommand) {
			userCommands.add(userCommand + "\n");
		}

		public String output() {
			return runTwitterConsoleWith(userCommands);
		}

		private String runTwitterConsoleWith(List<String> userCommands) {
			String cmd = new StringBuilder()
					.append("/usr/bin/java -cp ./target/classes ")
					.append("com.codurance.crafted_design.TwitterConsole")
					.toString();

			try {
				Process p = Runtime.getRuntime().exec(cmd);

				inp = new BufferedReader( new InputStreamReader(p.getInputStream()) );
				out = new BufferedWriter( new OutputStreamWriter(p.getOutputStream()) );

				PrintWriter writer = new PrintWriter( p.getOutputStream() );
				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

				for(String userCommand: userCommands) {
					writer.write(userCommand);
					writer.flush();
				}

				StringBuilder output = new StringBuilder();
				String outputLine = "";
				while ((outputLine = reader.readLine()) != null) {
					output.append(outputLine);
				}


				p.waitFor();
				return output.toString();

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		public static BufferedReader inp;
		public static BufferedWriter out;

	}

}
