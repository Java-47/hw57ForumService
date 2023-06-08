package telran.java47.forum.service;

import java.util.List;

import telran.java47.forum.dto.CommentCreateDto;
import telran.java47.forum.dto.PeriodCreateDto;
import telran.java47.forum.dto.PostCreateDto;
import telran.java47.forum.dto.PostDto;
import telran.java47.forum.dto.UpdatePostDto;

public interface ForumService {
	PostDto addPost(PostCreateDto postCreateDto, String author);

	PostDto findPostById(String id);

	boolean addLike(String id);

	List<PostDto> findPostsByAuthor(String author);

	PostDto addComment(String id, String author, CommentCreateDto commentCreateDto);

	PostDto deletePost(String id);

	List<PostDto> findPostByTags(List<String> tags);

	List<PostDto> findPostByPeriod(PeriodCreateDto period);

	PostDto updatePost(String id, UpdatePostDto update);
}
