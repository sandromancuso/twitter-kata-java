package console_twitter.com.codurance.crafted_design.unit.command;

import com.codurance.crafted_design.command.CommandFactory;
import com.codurance.crafted_design.command.PostCommand;
import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CommandFactoryShould {

	private static final String USER_POST_COMMAND = "Alice -> Hello.";

	@Test
	public void
	should_create_a_post_command() {
		CommandFactory commandFactory = new CommandFactory();

		Object command = commandFactory.create(USER_POST_COMMAND);

		assertThat(command, is(instanceOf(PostCommand.class)));
	}

}
