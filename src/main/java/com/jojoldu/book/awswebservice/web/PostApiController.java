package com.jojoldu.book.awswebservice.web;

import com.jojoldu.book.awswebservice.service.posts.PostService;
import com.jojoldu.book.awswebservice.web.dto.PostSaveRequestDto;
import com.jojoldu.book.awswebservice.web.dto.PostsResponseDto;
import com.jojoldu.book.awswebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {

  private final PostService postService;

  @PostMapping("/api/v1/posts")
  public Long save(@RequestBody PostSaveRequestDto requestDto) {
    return postService.save(requestDto);
  }

  @PutMapping("/api/v1/posts/{id}")
  public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
    return postService.update(id, requestDto);
  }

  @GetMapping("/api/v1/posts/{id}")
  public PostsResponseDto findById(@PathVariable Long id) {
    return postService.findById(id);
  }
}
