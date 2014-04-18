package main.com.codurance.crafted_design.use_cases;

import com.codurance.crafted_design.core.use_cases.AddPostUseCase;
import com.codurance.crafted_design.core.use_cases.domain.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddPostUseCaseShould {

	private static final String USER = "some user";
	private static final String POST_MESSAGE = "some message";

	@Mock private UserRepository userRepository;

	@Test public void
	create_a_post() {
		AddPostUseCase addPostUseCase = new AddPostUseCase(userRepository);

		addPostUseCase.addPost(USER, POST_MESSAGE);

		verify(userRepository).createPost(USER, POST_MESSAGE);
	}

}
