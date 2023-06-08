package telran.java47.forum.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import telran.java47.forum.dao.ForumRepository;
import telran.java47.forum.dto.CommentCreateDto;
import telran.java47.forum.dto.PeriodCreateDto;
import telran.java47.forum.dto.PostCreateDto;
import telran.java47.forum.dto.PostDto;
import telran.java47.forum.dto.UpdatePostDto;
import telran.java47.forum.dto.exceptions.NoContentException;
import telran.java47.forum.dto.exceptions.PostNotFoundException;
import telran.java47.forum.model.Comment;
import telran.java47.forum.model.Post;

@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {
	final ForumRepository forumRepository;
	final ModelMapper modelMapper;

	@Override
	public PostDto addPost(PostCreateDto postCreateDto, String author) {
		Post post = modelMapper.map(postCreateDto, Post.class);
		post.setAuthor(author);
		post.setDateCreated(LocalDate.now());
		forumRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto findPostById(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException());
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public boolean addLike(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException());
		post.addLike();
		forumRepository.save(post);
		throw new NoContentException();
	}

	@Override
	public List<PostDto> findPostsByAuthor(String author) {
		return forumRepository.findByAuthorIgnoreCase(author).map(p -> modelMapper.map(p, PostDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public PostDto addComment(String id, String author, CommentCreateDto commentCreateDto) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException());
		Comment comment = new Comment(author, commentCreateDto.getMessage(), LocalDate.now(), 0);
		post.getComments().add(comment);
		forumRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto deletePost(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException());
		forumRepository.delete(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> findPostByTags(List<String> tags) {

		return forumRepository.findByTagsIgnoreCaseIn(tags).map(p -> modelMapper.map(p, PostDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<PostDto> findPostByPeriod(PeriodCreateDto period) {
		return forumRepository.findByDateCreatedBetween(period.getDateFrom(), period.getDateTo())
				.map(p -> modelMapper.map(p, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public PostDto updatePost(String id, UpdatePostDto update) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException());
		post.update(update.getTitle(), update.getTags(), update.getContent());
		forumRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

}
