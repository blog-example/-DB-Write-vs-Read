package com.example.performance_test.repository;

import com.example.performance_test.dto.PostCommentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomPostRepository {
  Page<PostCommentDto> findAllWrite_PostWithCommentCount(Pageable pageable);

  Page<PostCommentDto> findAllRead_PostWithCommentCount(Pageable pageable);
}
