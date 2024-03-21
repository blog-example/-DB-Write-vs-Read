

# 쓰기 우선
# ab -n 1000 -c 100 http://localhost:8080/w/posts
# ab -n 1000 -c 100 -p "$PWD/scripts/comment.json" -T application/json http://localhost:8080/w/comment


# 읽기 우선
# ab -n 1000 -c 100 http://localhost:8080/r/posts
# ab -n 1000 -c 100 -p "$PWD/scripts/comment.json" -T application/json http://localhost:8080/r/comment

