package console_twitter.com.codurance.crafted_design.acceptance;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PostingAndReadingSteps {

	private TwitterConsoleTestingDSL twitterConsole;

	@Before
	public void initialise() {
		twitterConsole = TwitterConsoleTestingDSL.start();
	}

	@Given("^Alice posts a few messages$")
	public void alice_posts_a_few_messages() {
		twitterConsole.receives("Alice -> Hello, my name is Alice");
		twitterConsole.receives("Alice -> It's a lovely day today");
	}

	@When("^Bob reads Alice's messages$")
	public void bob_reads_Alice_s_messages() {
		twitterConsole.receives("Alice");
	}

	@Then("^Alice's messages are displayed in reverse chronological order$")
	public void alice_s_messages_are_displayed_in_reverse_chronological_order() {
		String output = twitterConsole.output();
		assertThat(output, is(
				"Alice - It's a lovely day today" +
				"Alice - Hello, my name is Alice" +
				"bye!"));

	}
}