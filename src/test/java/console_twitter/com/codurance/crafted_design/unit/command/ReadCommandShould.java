package console_twitter.com.codurance.crafted_design.unit.command;

import com.codurance.crafted_design.command.ReadCommand;
import com.codurance.crafted_design.core.domain.Post;
import com.codurance.crafted_design.core.domain.UserRepository;
import com.codurance.crafted_design.view.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReadCommandShould {

	private static final String USER_NAME = "Alice";
	private static final List<Post> USER_POSTS = asList(new Post("Alice", "Hi", new Date()));

	@Mock private UserRepository userRepository;
	@Mock private Console console;

	private ReadCommand readCommand;

	@Before
	public void initialise() {
		readCommand = new ReadCommand(userRepository, console, USER_NAME);
	}

	@Test public void
	should_read_posts_from_a_user() {
		readCommand.execute();

		verify(userRepository).postsBy(USER_NAME);
	}

	@Test public void
	should_print_posts() {
		given(userRepository.postsBy(USER_NAME)).willReturn(USER_POSTS);

		readCommand.execute();

		verify(console).write(USER_POSTS);
	}


}
