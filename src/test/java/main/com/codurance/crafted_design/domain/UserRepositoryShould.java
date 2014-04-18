package main.com.codurance.crafted_design.domain;

import com.codurance.crafted_design.core.domain.Post;
import com.codurance.crafted_design.core.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserRepositoryShould {

	private static final String UNKNOWN_USER = "unknown user";

	private UserRepository userRepository;

	@Before
	public void initialise() {
		userRepository = new UserRepository();
	}

	@Test public void
	should_not_return_any_posts_when_a_user_does_not_exist() {
		List<Post> posts = userRepository.postsBy(UNKNOWN_USER);

		assertThat(posts.isEmpty(), is(true));
	}

	@Test public void
	should_return_posts_for_the_specified_user() {
		userRepository.createPost("Alice", "Hi, I'm Alice");
		userRepository.createPost("Bob", "Hi, I'm Bob");

		List<Post> posts = userRepository.postsBy("Bob");

		assertThat(posts.size(), is(1));
		assertThat(posts.get(0), is(new Post("Bob", "Hi, I'm Bob")));
	}

	@Test public void
	return_posts_in_reverse_chronological_order() {
		userRepository.createPost("Alice", "Hi, I'm Alice");
		userRepository.createPost("Alice", "Hello again");

		List<Post> posts = userRepository.postsBy("Alice");

		assertThat(posts.get(0), is(new Post("Alice", "Hello again")));
		assertThat(posts.get(1), is(new Post("Alice", "Hi, I'm Alice")));
	}

}
