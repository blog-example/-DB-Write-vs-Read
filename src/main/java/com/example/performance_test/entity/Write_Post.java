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
@Table(name = "write_posts")
public class Write_Post {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "post_id")
  private long id;

  @Column(name = "title")
  private String title;

  @OneToMany(mappedBy = "post")
  private List<Write_Comment> comments;

  @Override
  public String toString() {
    return "Write_Post{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", comments=" + comments.size() +
            '}';
  }
}
