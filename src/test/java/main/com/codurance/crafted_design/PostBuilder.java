package main.com.codurance.crafted_design;

import com.codurance.crafted_design.core.domain.Post;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PostBuilder {

	public static Post aPost() {
		return new Post("user", "message", LocalDateTime.now());
	}

	public static Post aPost(String username, String message) {
		return new Post(username, message, LocalDateTime.now());
	}

	public static List<Post> posts(Post... posts) {
		return Arrays.asList(posts);
	}

}
