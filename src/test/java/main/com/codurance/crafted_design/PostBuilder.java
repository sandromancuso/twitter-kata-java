package main.com.codurance.crafted_design;

import com.codurance.crafted_design.core.domain.Post;

import java.util.Arrays;
import java.util.List;

public class PostBuilder {

	public static Post aPost() {
		return new Post("user", "message");
	}

	public static Post aPost(String username, String message) {
		return new Post(username, message);
	}

	public static List<Post> posts(Post... posts) {
		return Arrays.asList(posts);
	}

}
