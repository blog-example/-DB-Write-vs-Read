# 설계 비교 (쓰기 우선 vs 읽기 우선)

게시판을 2가지 형태의 설계로 구현하였습니다. <br />
하나는 조회 성능에 초점을 두고 설계하였고, 다른 하나는 쓰기 성능에 초점을 두고 설계하였습니다. <br />
동일한 요청이 들어왔을 때, 성능에서 어떤 차이가 있는지 비교하는 프로젝트 입니다.<br />

### 실행방법
1. /src/resources/application.yml 에서 mysql 접속을 위한 설정을 해주세요. <br />
2. /scripts/db-dummy-script.sh에서 적절한 댓글 개수를 설정 후 스크립트를 실행해주세요. <br />
3. 데이터 베이스에 wvsr이라는 데이터베이스를 생성해주세요.<br />
4. 스프링부트 서버를 실행하면 schema.sql과 data.sql을 바탕으로 디비에 데이터가 삽입됩니다.
5. /scripts/req.sh 에서 필요한 명령어를 사용해서 요청을 날려주세요.

