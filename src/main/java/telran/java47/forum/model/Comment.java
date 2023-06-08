package telran.java47.forum.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Comment {
	private String user;
	private String message;
	private LocalDate dateCreated;
	private int likes;

}
