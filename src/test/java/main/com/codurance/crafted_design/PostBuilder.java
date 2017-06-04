package main.com.codurance.crafted_design;

import com.codurance.crafted_design.core.domain.Post;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PostBuilder {

	public static Post aPost() {
		return new Post("user", "message", new Date());
	}

	public static Post aPost(String username, String message) {
		return new Post(username, message, new Date());
	}

	public static List<Post> posts(Post... posts) {
		return Arrays.asList(posts);
	}

}
