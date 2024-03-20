#!/bin/bash

# 변수 설정
POSTS_COUNT=100
COMMENTS_COUNT=100

# 현재 작업 디렉토리에 상대적인 경로로 data.sql 파일 생성 또는 기존 내용 삭제
DATA_SQL_PATH="$PWD/src/main/resources/data.sql"
> "$DATA_SQL_PATH"

# 게시글을 생성하는 SQL문 작성
for i in $(seq 1 $POSTS_COUNT); do
  echo "INSERT INTO write_posts (title) VALUES ('Post Title $i');" >> "$DATA_SQL_PATH"
  echo "INSERT INTO read_posts (title, comment_count) VALUES ('Post Title $i', $COMMENTS_COUNT);" >> "$DATA_SQL_PATH"
done

# 각 게시글에 대해 댓글을 생성하는 SQL문 작성
for i in $(seq 1 $POSTS_COUNT); do
  for j in $(seq 1 $COMMENTS_COUNT); do
    echo "INSERT INTO write_comments (comment, post_id) VALUES ('Comment $j for post $i', $j);" >> "$DATA_SQL_PATH"
    echo "INSERT INTO read_comments (comment, post_id) VALUES ('Comment $j for post $i', $j);" >> "$DATA_SQL_PATH"
  done
done
