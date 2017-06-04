package console_twitter.com.codurance.crafted_design.unit.command;

import com.codurance.crafted_design.command.Command;
import com.codurance.crafted_design.command.CommandExecutor;
import com.codurance.crafted_design.command.CommandFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CommandExecutorShould {

	private static final String USER_COMMAND = "Alice -> Hi";

	@Mock private CommandFactory commandFactory;
	@Mock private Command command;

	private CommandExecutor commandExecutor;

	@Before
	public void initialise() {
	    commandExecutor = new CommandExecutor(commandFactory);
	}

	@Test public void
	execute_a_command_related_to_the_user_input() {
		given(commandFactory.create(USER_COMMAND)).willReturn(command);

		commandExecutor.execute(USER_COMMAND);

	    verify(command).execute();
	}

}
