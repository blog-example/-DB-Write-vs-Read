package com.example.performance_test.repository;

import com.example.performance_test.dto.PostCommentDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class CustomPostRepositoryImpl implements CustomPostRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Page<PostCommentDto> findAllWrite_PostWithCommentCount(Pageable pageable) {


    List<Object[]> results = entityManager.createQuery(
                    "SELECT p.id, p.title, COUNT(c) "
                            + "FROM Write_Post p LEFT JOIN p.comments c "
                            + "GROUP BY p.id")
            .setFirstResult((int) pageable.getOffset())
            .setMaxResults(pageable.getPageSize())
            .getResultList();

    List<PostCommentDto> dtoList = results.stream()
            .map((r) -> new PostCommentDto((long) r[0], (String) r[1], (long) r[2]))
            .collect(Collectors.toList());

    Long count = entityManager.createQuery(
                    "SELECT COUNT(DISTINCT p.id) " +
                            "FROM Write_Post p LEFT JOIN p.comments c", Long.class)
            .getSingleResult();

    return new PageImpl<>(dtoList, pageable, count);
  }

  @Override
  public Page<PostCommentDto> findAllRead_PostWithCommentCount(Pageable pageable) {

    // post와 comment 개수
    List<Object[]> results = entityManager.createQuery(
                    "SELECT p.id, p.title, p.commentCount "
                            + "FROM Read_Post p")
            .setFirstResult((int) pageable.getOffset())
            .setMaxResults(pageable.getPageSize())
            .getResultList();

    List<PostCommentDto> dtoList = results.stream()
            .map((r) -> new PostCommentDto((long) r[0], (String) r[1], (long) r[2]))
            .collect(Collectors.toList());

    Long count = entityManager.createQuery(
                    "SELECT COUNT(p.id) " +
                            "FROM Read_Post p", Long.class)
            .getSingleResult();

    return new PageImpl<>(dtoList, pageable, count);
  }

}
