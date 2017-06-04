package console_twitter.com.codurance.crafted_design.unit.view;

import com.codurance.crafted_design.core.domain.Post;
import com.codurance.crafted_design.view.Console;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static main.com.codurance.crafted_design.PostBuilder.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConsoleShould {

	private Console console;
	private StringBuilder output;

	@Before
	public void initialise() {
	    console = new TestableConsole();
		output = new StringBuilder();
	}

	@Test public void
	should_write_posts() {
		List<Post> posts = posts(aPost("Alice", "Nice day today"),
								 aPost("Alice", "Hi, I'm Alice"));

		console.write(posts);

		assertThat(output(), is("Alice - Nice day today\n" + "Alice - Hi, I'm Alice\n"));
	}

	private class TestableConsole extends Console {
		@Override
		public void write(String text) {
			output.append(text + "\n");
		}
	}

	private String output() {
		return output.toString();
	}



}
