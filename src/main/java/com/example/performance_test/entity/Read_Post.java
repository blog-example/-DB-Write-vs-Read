package com.example.performance_test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "read_posts")
public class Read_Post {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "post_id")
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "comment_count")
  private long commentCount;

  @OneToMany(mappedBy = "readPost")
  private List<Read_Comment> comments;

  @Override
  public String toString() {
    return "Read_Post{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", commentCount=" + commentCount +
            '}';
  }
}
