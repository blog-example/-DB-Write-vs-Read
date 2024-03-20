package com.example.performance_test.repository;

import com.example.performance_test.entity.Write_Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Write_PostRepository extends JpaRepository<Write_Post, Long>, CustomPostRepository {

}
