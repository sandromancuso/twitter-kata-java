package main.com.codurance.crafted_design;

import com.codurance.crafted_design.core.domain.Post;

public class PostBuilder {

	public static Post aPost() {
		return new Post("user", "message");
	}

}
