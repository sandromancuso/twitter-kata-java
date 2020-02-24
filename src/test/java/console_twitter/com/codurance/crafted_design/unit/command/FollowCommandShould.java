package console_twitter.com.codurance.crafted_design.unit.command;

import com.codurance.crafted_design.command.FollowCommand;
import com.codurance.crafted_design.core.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FollowCommandShould {

	@Mock private UserRepository userRepository;

	@Test public void
	invoke_the_follow_use_case() {
		FollowCommand followCommand = new FollowCommand(userRepository, "Alice follows Bob");

		followCommand.execute();

		verify(userRepository).addFollower("Bob", "Alice");
	}

}
