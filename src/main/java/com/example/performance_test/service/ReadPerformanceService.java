package com.example.performance_test.service;

import com.example.performance_test.dto.PostCommentDto;
import com.example.performance_test.entity.Read_Comment;
import com.example.performance_test.entity.Read_Post;
import com.example.performance_test.entity.Write_Comment;
import com.example.performance_test.entity.Write_Post;
import com.example.performance_test.repository.Read_CommentRepository;
import com.example.performance_test.repository.Read_PostRepository;
import com.example.performance_test.repository.Write_CommentRepository;
import com.example.performance_test.repository.Write_PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ReadPerformanceService {

  @Autowired
  private Read_PostRepository readPostRepository;

  @Autowired
  private Read_CommentRepository readCommentRepository;

  public Page<PostCommentDto> getPostList(Pageable pageable) {
    Page<PostCommentDto> result = readPostRepository.findAllRead_PostWithCommentCount(pageable);

    return result;
  }

  @Transactional
  public void createComment(long postId, String content) {
    Read_Post post = readPostRepository.findByIdWithLock(postId).orElseThrow(() -> new EntityNotFoundException("no post"));
    Read_Comment comment = new Read_Comment(content, post);

    post.setCommentCount(post.getCommentCount() + 1);
    readCommentRepository.save(comment);
  }
}
