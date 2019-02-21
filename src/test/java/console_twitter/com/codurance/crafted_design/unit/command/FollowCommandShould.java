package console_twitter.com.codurance.crafted_design.unit.command;

import com.codurance.crafted_design.command.FollowCommand;
import com.codurance.crafted_design.core.use_cases.FollowUseCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FollowCommandShould {

	@Mock
	private FollowUseCase followUseCase;

	@Test public void
	invoke_the_follow_use_case() {
		FollowCommand followCommand = new FollowCommand(followUseCase, "Alice follows Bob");

		followCommand.execute();

		verify(followUseCase).follow("Bob", "Alice");
	}

}
