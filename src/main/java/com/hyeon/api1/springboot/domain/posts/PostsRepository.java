package com.hyeon.api1.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Dao와 같은 DB Layer 접근자
// Entity 클래스와 함께 위치해야함
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    // 추후 Querydsl 사용 (p.147)
}
