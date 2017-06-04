package main.com.codurance.crafted_design.use_cases;

import com.codurance.crafted_design.core.domain.UserRepository;
import com.codurance.crafted_design.core.use_cases.FollowUseCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FollowUseCaseShould {

	@Mock
	private UserRepository userRepository;

	@Test public void
	add_a_follower() {
		FollowUseCase followUseCase = new FollowUseCase(userRepository);

		followUseCase.follow("Alice", "Bob");

		verify(userRepository).addFollower("Alice", "Bob");
	}

}
