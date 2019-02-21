package console_twitter.com.codurance.crafted_design.unit;

import com.codurance.crafted_design.command.CommandExecutor;
import com.codurance.crafted_design.Twitter;
import com.codurance.crafted_design.view.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TwitterShould {

	private static final String POST_COMMAND = "Alice -> Hello";
	private static final String READ_COMMAND = "Alice";
	private static final String EXIT = "exit";
	@Mock private Console console;
	@Mock private CommandExecutor commandExecutor;

	private Twitter twitter;

	@Before
	public void initialise() {
		twitter = new Twitter(console, commandExecutor);
	}

	@Test public void
	terminate_when_an_exit_command_is_received() {
		given(console.readline()).willReturn(POST_COMMAND, EXIT);

		twitter.start();

		verify(console).write("bye!");
	}

	@Test public void
	execute_user_commands_until_user_exits_the_application() {
		given(console.readline()).willReturn(POST_COMMAND, READ_COMMAND, EXIT);

		twitter.start();

		InOrder inOrder = Mockito.inOrder(commandExecutor, console);
		inOrder.verify(commandExecutor).execute(POST_COMMAND);
		inOrder.verify(commandExecutor).execute(READ_COMMAND);
		verify(console).write("bye!");
	}

}
