package telran.java47.forum.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.java47.forum.model.Post;

public interface ForumRepository extends MongoRepository<Post, String> {
	Stream<Post> findByAuthorIgnoreCase(String author);

	Stream<Post> findByTagsIgnoreCaseIn(List<String> tags);

	Stream<Post> findByDateCreatedBetween(LocalDate dateFrom, LocalDate dateTo);
}
