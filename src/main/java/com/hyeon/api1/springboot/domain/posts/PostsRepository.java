package com.hyeon.api1.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Dao와 같은 DB Layer 접근자
// Entity 클래스와 함께 위치해야함
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
