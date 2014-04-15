package console_twitter.com.codurance.crafted_design.acceptance;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartAndStopStepdefs {

	private TwitterConsoleTestingDSL twitterConsole;

	@Before
	public void initialise() {
		twitterConsole = TwitterConsoleTestingDSL.start();
	}

	@Given("^the application receives an 'exit' command$")
	public void the_application_receives_an_exit_command() throws Throwable {
		twitterConsole.receives("some user command");
		twitterConsole.receives("exit");
	}

	@Then("^the application should terminate$")
	public void the_application_should_terminate() throws Throwable {
		String output = twitterConsole.output();
		assertThat(output, is("bye!"));
	}

}
