package com.example.performance_test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Entity
@Table(name = "read_comments")
public class Read_Comment {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "comment_id")
  private long commendId;

  @Column(name = "comment")
  private String comment;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private Read_Post readPost;

  public Read_Comment(String comment, Read_Post post) {
    this.comment = comment;
    this.readPost = post;
  }

  @Override
  public String toString() {
    return "Read_Comment{" +
            "commendId=" + commendId +
            ", comment='" + comment + '\'' +
            ", readPost=" + readPost +
            '}';
  }
}
