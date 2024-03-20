package com.example.performance_test.service;

import com.example.performance_test.dto.PostCommentDto;
import com.example.performance_test.entity.Write_Comment;
import com.example.performance_test.entity.Write_Post;
import com.example.performance_test.repository.Write_CommentRepository;
import com.example.performance_test.repository.Write_PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class WritePerformanceService {

  @Autowired
  private Write_PostRepository writePostRepository;

  @Autowired
  private Write_CommentRepository writeCommentRepository;

  public Page<PostCommentDto> getPostList(Pageable pageable) {
    Page<PostCommentDto> result = writePostRepository.findAllWrite_PostWithCommentCount(pageable);

    return result;
  }

  @Transactional
  public void createComment(long postId, String content) {
    Write_Post post = writePostRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("no post"));
    Write_Comment comment = new Write_Comment(content, post);

    writeCommentRepository.save(comment);
  }
}
