package com.jojoldu.book.awswebservice.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

//<Entity Class, PK type>
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
