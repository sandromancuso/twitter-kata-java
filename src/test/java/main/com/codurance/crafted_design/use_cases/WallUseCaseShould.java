package main.com.codurance.crafted_design.use_cases;

import com.codurance.crafted_design.core.domain.Post;
import com.codurance.crafted_design.core.domain.UserRepository;
import com.codurance.crafted_design.core.use_cases.WallUseCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static main.com.codurance.crafted_design.PostBuilder.aPost;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class WallUseCaseShould {

	private static final List<Post> WALL_POSTS = asList(aPost());

	@Mock
	private UserRepository userRepository;
	private WallUseCase wallUseCase;

	@Before
	public void initialise() {
		wallUseCase = new WallUseCase(userRepository);
	}

	@Test public void
	should_return_wall_posts_for_a_user() {
		given(userRepository.wallPostsFor("Alice")).willReturn(WALL_POSTS);

		List<Post> posts = wallUseCase.wallPostsFor("Alice");

		assertThat(posts, is(WALL_POSTS));
	}



}
