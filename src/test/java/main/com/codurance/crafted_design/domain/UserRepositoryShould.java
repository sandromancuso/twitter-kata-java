package main.com.codurance.crafted_design.domain;

import com.codurance.crafted_design.core.domain.Clock;
import com.codurance.crafted_design.core.domain.Post;
import com.codurance.crafted_design.core.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryShould {

	private static final String UNKNOWN_USER = "unknown user";

	private static final LocalDateTime TODAY_AT_10_00_00 = todayAt(10, 00, 00);
	private static final LocalDateTime TODAY_AT_10_00_01 = todayAt(10, 00, 01);
	private static final LocalDateTime TODAY_AT_10_05_10 = todayAt(10, 05, 10);

	@Mock
	private Clock clock;

	private UserRepository userRepository;

	@Before
	public void initialise() {
		userRepository = new UserRepository(clock);
	}

	@Test public void
	should_not_return_any_posts_when_a_user_does_not_exist() {
		List<Post> posts = userRepository.postsBy(UNKNOWN_USER);

		assertThat(posts.isEmpty(), is(true));
	}

	@Test public void
	should_return_posts_for_the_specified_user() {
		userRepository.addPost("Alice", "Hi, I'm Alice");
		userRepository.addPost("Bob", "Hi, I'm Bob");

		List<Post> posts = userRepository.postsBy("Bob");

		assertThat(posts.size(), is(1));
		assertThat(posts.get(0), is(new Post("Bob", "Hi, I'm Bob", clock.now())));
	}

	@Test public void
	return_posts_in_reverse_chronological_order() {
		userRepository.addPost("Alice", "Hi, I'm Alice");
		userRepository.addPost("Alice", "Hello again");

		List<Post> posts = userRepository.postsBy("Alice");

		assertThat(posts.get(0), is(new Post("Alice", "Hello again", clock.now())));
		assertThat(posts.get(1), is(new Post("Alice", "Hi, I'm Alice", clock.now())));
	}

	@Test public void
	return_just_a_users_post_when_user_does_not_follow_anyone() {
		userRepository.addPost("Alice", "Hi, I'm Alice");

		List<Post> posts = userRepository.wallPostsFor("Alice");

	    assertThat(posts.size(), is(1));
	    assertThat(posts.get(0), is(new Post("Alice", "Hi, I'm Alice", clock.now())));
	}

	@Test public void
	return_posts_from_the_users_that_a_specified_user_follows() {
		userRepository.addPost("Alice", "Hi, I'm Alice");
		userRepository.addFollower("Alice", "Bob");

		List<Post> wallPosts = userRepository.wallPostsFor("Bob");

	    assertThat(wallPosts.size(), is(1));
	    assertThat(wallPosts.get(0), is(new Post("Alice", "Hi, I'm Alice", clock.now())));
	}

	@Test public void
	return_posts_from_users_and_users_she_follows_in_reverse_chronological_order() {
		given(clock.now()).willReturn(TODAY_AT_10_00_00, TODAY_AT_10_00_01, TODAY_AT_10_05_10);

		userRepository.addPost("Alice", "Hi, I'm Alice");
		userRepository.addPost("Bob", "Hi, I'm Bob");
		userRepository.addPost("Charlie", "Hi, I'm Charlie");
		
		userRepository.addFollower("Bob", "Alice");
		userRepository.addFollower("Charlie", "Alice");

		List<Post> wallPosts = userRepository.wallPostsFor("Alice");

	    assertThat(wallPosts.size(), is(3));
	    assertThat(wallPosts.get(0), is(new Post("Charlie", "Hi, I'm Charlie", TODAY_AT_10_05_10)));
	    assertThat(wallPosts.get(1), is(new Post("Bob", "Hi, I'm Bob", TODAY_AT_10_00_01)));
	    assertThat(wallPosts.get(2), is(new Post("Alice", "Hi, I'm Alice", TODAY_AT_10_00_00)));
	}

	private static LocalDateTime todayAt(int hour, int minute, int second) {
		return LocalDateTime.now().withHour(hour).withMinute(minute).withSecond(second).withNano(0);
	}

}
