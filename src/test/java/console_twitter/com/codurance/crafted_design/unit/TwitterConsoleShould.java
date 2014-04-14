package console_twitter.com.codurance.crafted_design.unit;

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

	@Mock private Console console;
	private TwitterConsole twitter;

	@Before
	public void initialise() {
		twitter = new TwitterConsole(console);
	}

	@Test public void
	should_terminate_when_an_exit_command_is_received() {
		given(console.readline()).willReturn("a command", "exit");

		twitter.start();

		verify(console).write("bye!");
	}

}
