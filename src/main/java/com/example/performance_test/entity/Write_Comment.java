package com.example.performance_test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "write_comments")
public class Write_Comment {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "comment_id")
  private long commendId;

  @Column(name = "comment")
  private String comment;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private Write_Post post;

  public Write_Comment(String comment, Write_Post post) {
    this.comment = comment;
    this.post = post;
  }

  @Override
  public String toString() {
    return "Write_Comment{" +
            "commendId=" + commendId +
            ", comment='" + comment + '\'' +
            ", post=" + post +
            '}';
  }
}
