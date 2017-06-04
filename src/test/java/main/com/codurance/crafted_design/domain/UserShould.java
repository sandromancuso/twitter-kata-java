package main.com.codurance.crafted_design.domain;

import com.codurance.crafted_design.core.domain.User;
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserShould {

	private User bob = new User("Bob");
	private User alice = new User("Alice");;

	@Test public void
	return_the_user_name() {
		assertThat(alice.userName(), is("Alice"));
	}

	@Test public void
	return_the_following_users() {
		alice.follows(bob);

		assertThat(alice.followingUsers(), contains(bob));
	}

}
