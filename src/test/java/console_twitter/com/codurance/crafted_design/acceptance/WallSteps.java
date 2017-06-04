package console_twitter.com.codurance.crafted_design.acceptance;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WallSteps {

	private TwitterConsoleTestingDSL twitterConsole;

	@Before
	public void initialise() {
		twitterConsole = TwitterConsoleTestingDSL.start();
	}

	@Given("^Bob posts a few messages$")
	public void bob_posts_a_few_messages() {
		twitterConsole.receives("Bob -> Hi, I'm Bob");
		twitterConsole.receives("Bob -> It's a lovely day today");
	}

	@Given("^Charlie posts a few messages$")
	public void charlie_posts_a_few_messages() {
		twitterConsole.receives("Charlie -> Hi, I'm Charlie");
		twitterConsole.receives("Charlie -> I'm in London today.");
	}

	@Given("^Charlie follows Bob$")
	public void charlie_follows_Bob() {
		twitterConsole.receives("Charlie follows Bob");
	}

	@When("^Charlie checks his wall$")
	public void charlie_checks_his_wall() {
		twitterConsole.receives("Charlie wall");
	}

	@Then("^messages from Bob and Charlie are displayed in reverse chronological order$")
	public void messages_from_Bob_and_Charlie_are_displayed_in_reverse_chronological_order() {
		String output = twitterConsole.output();
		assertThat(output, is(
								"Charlie - I'm in London today." +
								"Charlie - Hi, I'm Charlie" +
								"Bob - It's a lovely day today" +
								"Bob - Hi, I'm Bob" +
								"bye!"));
	}


}
