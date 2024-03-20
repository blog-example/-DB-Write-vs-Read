package com.example.performance_test.controller;


import com.example.performance_test.dto.PostCommentDto;
import com.example.performance_test.service.ReadPerformanceService;
import com.example.performance_test.service.WritePerformanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PostCommentController {

  @Autowired
  private WritePerformanceService writePerformanceService;

  @Autowired
  private ReadPerformanceService readPerformanceService;

  @GetMapping("/w/posts")
  public List<PostCommentDto> getWriteList(Pageable pageable) {
    Page<PostCommentDto> list = writePerformanceService.getPostList(pageable);

    return list.getContent();
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PostMapping("/w/comment")
  public void createWriteComment(@RequestBody Map<String, String> body) {
    String postId = body.get("postId");
    String comments = body.get("comment");

    writePerformanceService.createComment(Long.parseLong(postId), comments);
  }


  @GetMapping("/r/posts")
  public List<PostCommentDto> getReadList(Pageable pageable) {
    Page<PostCommentDto> list = readPerformanceService.getPostList(pageable);

    return list.getContent();
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PostMapping("/r/comment")
  public void createReadComment(@RequestBody Map<String, String> body) {
    String postId = body.get("postId");
    String comments = body.get("comment");

    readPerformanceService.createComment(Long.parseLong(postId), comments);
  }


}
