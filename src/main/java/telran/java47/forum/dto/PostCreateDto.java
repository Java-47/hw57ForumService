package telran.java47.forum.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import telran.java47.forum.model.Comment;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter

public class PostCreateDto {
	String id;
	String title;
	String content;
	String author;
	LocalDate dateCreated;
	String[] tags;
	int likes;
	List<Comment> comments;

}
