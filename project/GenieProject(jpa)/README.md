# GenieProject(JPA+QueryDSL)

### 1. 프로젝트 목적과 계획

- 기존에 배웠던 MyBatis 대신 자바 ORM기술을 활용하여 데이터 베이스에 접근할 수 있도록 하는 프로젝트
- 프로젝트에서 맡은 역할 부분을 최대한 mybatis를 스프링데이터JPA 및 QueryDSL로 변환하되, 복잡한 쿼리는 MyBatis를 이용하는 것이 목적
- 프로젝트의 끝은 존재하지 않고 새로 알게 되는걸 하나씩 적용시켜가는 성장형 프로젝트를 지향

### 2.  참고한 자료

- 김영한의 스프링 jpa 로드맵 + 스프링 로드맵
- stackoverflow
- google
- https://docs.spring.io/spring-data/jpa/docs/1.7.1.RELEASE/reference/html/#jpa.query-methods.at-query

### 3. 배운점

- 최대한 블로그로 남기도록 하되, 표현이 애매하면 코드에 그대로 작성함.
- commit 내역에서 오류 작업 및 수정작업에 대한 인덱스를 최대한 정확히 작성하여
  오류 해결에 대한 이정표 작업.

#### 4. 해결해야할 부분

- DTO문제 < -- 해결(yml 참조)
- 개인정보 수정 < -- 해결
- 카테고리, 태그 별 검색 <-- 해결: 좌표 문제
- 주문결제시 외래키 입력 <-- DTO에 담아서 해결
- 쿼리문 최대한 스프링데이터JPA와 Querydsl로 해결해보기

### 5. 추가적으로 구현하고 싶은 부분

- jwt방식의 로그인
- bindingresult
- OAuth
