package console_twitter.com.codurance.crafted_design.unit.command;

import com.codurance.crafted_design.command.PostCommand;
import com.codurance.crafted_design.core.use_cases.AddPostUseCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PostCommandShould {

	@Mock
	AddPostUseCase addPostUseCase;

	@Test public void
	should_invoke_post_use_case() {
		PostCommand postCommand = new PostCommand(addPostUseCase, "Alice -> Hello all");

		postCommand.execute();

		verify(addPostUseCase).addPost("Alice", "Hello all");
	}

}
