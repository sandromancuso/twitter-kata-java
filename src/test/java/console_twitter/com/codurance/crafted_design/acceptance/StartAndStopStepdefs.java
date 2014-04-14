package console_twitter.com.codurance.crafted_design.acceptance;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartAndStopStepdefs {

	private TwitterConsole twitterConsole;

	@Given("^the application receives an 'exit' command$")
	public void the_application_receives_an_exit_command() throws Throwable {
		twitterConsole = TwitterConsole.start();
		twitterConsole.receives("exit");
	}

	@Then("^the application should terminate$")
	public void the_application_should_terminate() throws Throwable {
		String output = twitterConsole.output();
		assertThat(output, is("> bye!\n"));
	}

	static public class TwitterConsole {

		private List<String> userCommands = new ArrayList<>();

		public static TwitterConsole start() {
			return new TwitterConsole();
		}

		public void receives(String userCommand) {
			userCommands.add(userCommand);
		}

		public String output() {
			return "";
		}

	}

}
