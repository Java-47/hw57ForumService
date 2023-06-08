package telran.java47.forum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import telran.java47.forum.dto.CommentCreateDto;
import telran.java47.forum.dto.PeriodCreateDto;
import telran.java47.forum.dto.PostCreateDto;
import telran.java47.forum.dto.PostDto;
import telran.java47.forum.dto.UpdatePostDto;
import telran.java47.forum.service.ForumService;

@RestController
@RequiredArgsConstructor
public class ForumController {
	final ForumService forumService;

	@PostMapping("/forum/post/{author}")
	public PostDto addStudent(@PathVariable String author, @RequestBody PostCreateDto postCreateDto) {
		return forumService.addPost(postCreateDto, author);
	}

	@GetMapping("/forum/post/{id}")
	public PostDto findPostById(@PathVariable String id) {
		return forumService.findPostById(id);
	}

	@PutMapping("/forum/post/{id}/like")
	public boolean addLike(@PathVariable String id) {
		return forumService.addLike(id);
	}

	@GetMapping("/forum/posts/author/{author}")
	public List<PostDto> findPostByAuthor(@PathVariable String author) {
		return forumService.findPostsByAuthor(author);
	}

	@PutMapping("/forum/post/{id}/comment/{author}")
	public PostDto addComment(@PathVariable String id, @PathVariable String author,
			@RequestBody CommentCreateDto commentCreateDto) {
		return forumService.addComment(id, author, commentCreateDto);
	}

	@DeleteMapping("/forum/post/{id}")
	public PostDto deletePost(@PathVariable String id) {
		return forumService.deletePost(id);
	}

	@PostMapping("/forum/posts/tags")
	public List<PostDto> findPostByTags(@RequestBody List<String> tags) {
		return forumService.findPostByTags(tags);
	}

	@PostMapping("/forum/posts/period")
	public List<PostDto> findPostByPeriod(@RequestBody PeriodCreateDto period) {
		return forumService.findPostByPeriod(period);
	}

	@PutMapping("/forum/post/{id}")
	public PostDto updatePost(@PathVariable String id, @RequestBody UpdatePostDto update) {
		return forumService.updatePost(id, update);
	}

}
