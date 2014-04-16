package console_twitter.com.codurance.crafted_design.unit.command;

import com.codurance.crafted_design.command.CommandFactory;
import com.codurance.crafted_design.command.PostCommand;
import com.codurance.crafted_design.core.use_cases.AddPostUseCase;
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
	@Mock private AddPostUseCase addPostUseCase;

	@Test
	public void
	should_create_a_post_command() {
		CommandFactory commandFactory = new CommandFactory(addPostUseCase);

		Object command = commandFactory.create(USER_POST_COMMAND);

		assertThat(command, is(instanceOf(PostCommand.class)));
	}

}
