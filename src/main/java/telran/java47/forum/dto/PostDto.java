package telran.java47.forum.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import telran.java47.forum.model.Comment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	String id;
	String title;
	String content;
	String author;
	LocalDate dateCreated;
	String[] tags;
	int likes;
	List<Comment> comments;
}
