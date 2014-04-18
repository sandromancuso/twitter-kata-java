package console_twitter.com.codurance.crafted_design.unit.command;

import com.codurance.crafted_design.command.CommandFactory;
import com.codurance.crafted_design.command.PostCommand;
import com.codurance.crafted_design.command.ReadCommand;
import com.codurance.crafted_design.core.use_cases.AddPostUseCase;
import com.codurance.crafted_design.core.use_cases.ReadPostsUseCase;
import com.codurance.crafted_design.infrastructure.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CommandFactoryShould {

	private static final String USER_POST_COMMAND = "Alice -> Hello.";
	private static final String USER_READ_COMMAND = "Alice";

	@Mock private AddPostUseCase addPostUseCase;
	@Mock private ReadPostsUseCase readPostsUseCase;
	@Mock private Console console;

	private CommandFactory commandFactory;

	@Before
	public void initialise() {
		commandFactory = new CommandFactory(addPostUseCase, readPostsUseCase, console);
	}

	@Test
	public void
	should_create_a_post_command() {
		Object command = commandFactory.create(USER_POST_COMMAND);

		assertThat(command, is(instanceOf(PostCommand.class)));
	}

	@Test public void
	should_create_a_read_command() {
		Object command = commandFactory.create(USER_READ_COMMAND);

	    assertThat(command, is(instanceOf(ReadCommand.class)));
	}

}
