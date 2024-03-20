package com.example.performance_test.repository;

import com.example.performance_test.entity.Read_Post;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface Read_PostRepository extends JpaRepository<Read_Post, Long>, CustomPostRepository{

  @Lock(LockModeType.PESSIMISTIC_READ)
  @Query("SELECT p FROM Read_Post p WHERE p.id = :postId")
  Optional<Read_Post> findByIdWithLock(@Param("postId") long postId);
}
