package console_twitter.com.codurance.crafted_design.unit;

import com.codurance.crafted_design.command.CommandExecutor;
import com.codurance.crafted_design.TwitterConsole;
import com.codurance.crafted_design.infrastructure.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TwitterConsoleShould {

	private static final String SOME_POST_COMMAND = "Alice -> Hello";
	private static final String EXIT = "exit";
	@Mock private Console console;
	@Mock private CommandExecutor commandExecutor;

	private TwitterConsole twitter;

	@Before
	public void initialise() {
		twitter = new TwitterConsole(console, commandExecutor);
	}

	@Test public void
	terminate_when_an_exit_command_is_received() {
		given(console.readline()).willReturn("a command", "exit");

		twitter.start();

		verify(console).write("bye!");
	}

	@Test public void
	execute_the_user_command() {
		given(console.readline()).willReturn(SOME_POST_COMMAND, EXIT);

		twitter.start();

		verify(commandExecutor).execute(SOME_POST_COMMAND);
	}

}
