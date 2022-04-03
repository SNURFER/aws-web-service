package com.jojoldu.book.awswebservice.service.posts;

import com.jojoldu.book.awswebservice.domain.post.Posts;
import com.jojoldu.book.awswebservice.domain.post.PostsRepository;
import com.jojoldu.book.awswebservice.web.dto.PostSaveRequestDto;
import com.jojoldu.book.awswebservice.web.dto.PostsResponseDto;
import com.jojoldu.book.awswebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
  //if not final repository beans are not injected... why?? TT
  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostSaveRequestDto requestDto) {
    return postsRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto) {
    Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no post with this ID = " + id));
    posts.update(requestDto.getTitle(), requestDto.getContent());
    return id;
  }

  public PostsResponseDto findById (Long id) {
    Posts entity = postsRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("no posts with this ID =" + id));
    return new PostsResponseDto(entity);
  }
}
