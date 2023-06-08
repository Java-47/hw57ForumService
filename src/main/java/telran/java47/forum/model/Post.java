package telran.java47.forum.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Post {
	@Id
	String id;
	@Setter
	String title;
	@Setter
	String content;
	@Setter
	String author;
	@Setter
	LocalDate dateCreated;
	@Setter
	String[] tags;
	@Setter
	int likes;
	@Setter
	List<Comment> comments = new ArrayList<>();;

	public void addLike() {
		setLikes(getLikes() + 1);
	}

	public void update(String title, String[] tags, String content) {
		setTitle(title);
		setTags(tags);
		setContent(content);

	}
}
