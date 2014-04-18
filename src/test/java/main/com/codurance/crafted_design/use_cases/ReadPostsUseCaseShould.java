package main.com.codurance.crafted_design.use_cases;

import com.codurance.crafted_design.core.domain.Post;
import com.codurance.crafted_design.core.domain.UserRepository;
import com.codurance.crafted_design.core.use_cases.ReadPostsUseCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ReadPostsUseCaseShould {

	private static final String ALICE = "Alice";
	private static final List<Post> ALICE_POSTS = asList(new Post());

	@Mock private UserRepository userRepository;

	@Test public void
	should_return_posts_from_a_user() {
		ReadPostsUseCase readPostsUseCase = new ReadPostsUseCase(userRepository);
		given(userRepository.postsBy(ALICE)).willReturn(ALICE_POSTS);

		List<Post> posts = readPostsUseCase.postsBy(ALICE);

		assertThat(posts, is(ALICE_POSTS));
	}
}
