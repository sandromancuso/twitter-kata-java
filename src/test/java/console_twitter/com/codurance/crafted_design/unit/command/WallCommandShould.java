package console_twitter.com.codurance.crafted_design.unit.command;

import com.codurance.crafted_design.command.WallCommand;
import com.codurance.crafted_design.core.domain.Post;
import com.codurance.crafted_design.core.use_cases.WallUseCase;
import com.codurance.crafted_design.view.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WallCommandShould {

	private static final List<Post> WALL_POSTS = asList(new Post("Alice", "Hi, I'm Alice"),
														new Post("Bob", "Hi, I'm Bob"));

	@Mock private Console console;
	@Mock private WallUseCase wallUseCase;
	private WallCommand wallCommand;

	@Before
	public void initialise() {
		wallCommand = new WallCommand(wallUseCase, console, "Alice wall");
	}

	@Test public void
	read_wall_posts() {
		wallCommand.execute();

		verify(wallUseCase).wallPostsFor("Alice");
	}

	@Test public void
	print_wall_posts() {
		given(wallUseCase.wallPostsFor("Alice")).willReturn(WALL_POSTS);

		wallCommand.execute();

		verify(console).write(WALL_POSTS);
	}
}
