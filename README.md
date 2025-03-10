# 2024 겨울방학 프로젝트

## 완성 소감
학기 시작 이슈로 기능만 완성하고, CSS로 페이지를 꾸미거나 다듬지를 못한 게 아쉽습니다.
비록 흐지부지 끝난 계획이긴 하지만, Spring Boot로 직접 게시판을 만들어 보니 글로만 읽었을 때 막연했던 MVC 패턴을 더 잘 이해할 수 있었습니다.

이 프로젝트는 개인적인 문제를 제외하면 약 7~8주 정도 걸렸습니다.
지금 와서 제 코드를 다시 보니 "왜 이렇게 만들었지?" 싶은 부분이 많고, 깔끔하지 못한 코드도 꽤 보입니다. 
다시 Spring Boot로 웹 페이지를 만든다면 훨씬 수월하고 깔끔하게 개발할 수 있을 것 같습니다.

다음에는 Node.js를 사용하여 웹을 개발해 볼 생각입니다.
이번 프로젝트에서 부족했던 점들을 살려서 유지보수하기 쉽고 효율적인 코드를 작성해보려고 합니다.

## 기간
- 2024년 12월 25일 ~ 2025년 03월 02일

## 프로젝트 설명
이 프로젝트는 Spring Boot를 사용하여 ``로그인``, ``회원가입``, ``게시판 기능``을 구현한 웹 페이지입니다.<br>
회원가입 후 로그인을 통해서 게시글 작성 및 댓글을 작성하고 관리할 수 있습니다.

## 기술 스택
- **Backend**: Spring Boot 3.4.1, JAVA-17
- **Frontend**: HTML, CSS, JavaScript, Thymeleaf
- **DataBase**: MySQL - 8.0.40 [ 서버 컴퓨터 설치 - Workbench ]
- **IDE**: IntelliJ IDEA
- **Cloud Service**: ~~[AWS(Amazone Web Service) - Ubuntu](https://eu-north-1.console.aws.amazon.com/ec2/home?region=eu-north-1#Home:)~~ [ AWS 비용 문제로 호스팅 중단 ]

## 테스트 아이디
![테스트 아이디](https://github.com/user-attachments/assets/93f59501-2081-4c7a-b225-e156ce3a5a72)

### Role_User

|아이디|비밀번호|
|---------|----|
|Test_User_1|1111|
|Test_User_2|1111|
|Test_User_3|1111|
### Role_Admin
|아이디|비밀번호|
|---------|----|
|Test_Admin_1|1111|
|Test_Admin_2|1111|
|Test_Admin_3|1111|

## 스프링 부트 의존성 (Spring Boot Dependencies)
- Spring Web <br>
내장 서버를 사용하기 위해 추가했습니다.
- Spring Data JPA <br>
데이터베이스와 어플리케이션 간의 데이터 저장 및 조회 작업을 간단하게 구현하기 위해 추가했습니다.
- MySQL Driver <br>
MySQL과 연결하기위해 추가했습니다.
- Spring Security <br>
어플리케이션의 인증, 권한 관리를 처리하기 위해 추가했습니다.
- Thymeleaf <br>
동적 웹 페이지를 작성하기 위해서 추가했습니다.
- Spring Boot DevTools(Optional) <br>
서버 실행 중 코드 수정시 자동으로 재시작되게 해줍니다. 생산성을 높이기 위해 추가했습니다.
- Validation <br>
입력 값이 올바른지 확인하기 위해 추가했습니다.
- Lombok <br>
Getter, Setter와 같이 반복적인 Java 코드를 줄이기 위해 추가했습니다.

## ERD
- ERD(Entity Relationship Diagram)
![ERD](https://github.com/user-attachments/assets/f18a7ac7-45b4-45a0-b557-a539b2652ac8)

## 페이지 뷰
- 메인 페이지 / 로그인 O
![메인 페이지 / 로그인 O](https://github.com/user-attachments/assets/4139e180-391b-4669-9297-98185a320135)
- 메인 페이지 / 로그인 X
![메인 페이지 / 로그인 X](https://github.com/user-attachments/assets/6f6f91d4-27db-48a8-bafc-2c06bdcd417a)
- 로그인 페이지
![로그인 페이지](https://github.com/user-attachments/assets/c9c4804b-676b-4c89-8d04-8e33cd1fec32)
- 회원가입 페이지
![회원가입 페이지](https://github.com/user-attachments/assets/27e6f8a7-59db-4ed0-855b-6fe94528e7ce)
- 게시판 페이지
![게시판 페이지](https://github.com/user-attachments/assets/2db9d65f-7c4c-439e-9c27-872e875eab12)
- 게시판 관리 페이지 / 접근 허용
![게시판 관리 페이지 / 접근 허용](https://github.com/user-attachments/assets/a2668ac0-11df-402a-b7ca-83d1480d0305)
- 게시판 관리 페이지 / 접근 제한
![게시판 관리 페이지 / 접근 제한](https://github.com/user-attachments/assets/17356236-55df-4b95-a750-2cfb59da799d)

## 추가 사항
- 포트 충돌로 인해서 포트번호를 8081로 변경
- 우분투의 메모리 용량이 부족하여 ``./gradlew build``시 컴퓨터가 계속 멈춰, Swap 메모리 2GB 설정
- 서버 강제 종료 및 재시작 코드 추가 ``※밑의 1번 details 참고``
- 서버 종료, Git pull, Gradlew build, 서버 실행 자동화 코드 추가 ``※밑의 2번 details 참고``
- IntelliJ에서 DB 연결을 위해 서버 컴퓨터 UFW 활성화 및 MySQL의 mysqld.cnf 파일 수정

<details>
    <summary>1번 restart.sh 코드</summary>

resetart.sh<br>
서버를 ``강제 종료`` 하여 ``재시작``을 해야 할 때를 위해 ``종료`` 및 ``실행`` 코드를 추가했습니다.
<pre><code>
#!/bin/bash

# 기존 서버 종료
ps -ef | grep "WinterProject2024-0.0.1-SNAPSHOT.jar" | grep -v grep | awk '{print $2}' | xargs kill -9 2> /dev/null

if [ $? -eq 0 ];then
    echo "my-application Stop Success"
else
    echo "my-application Not Running"
fi

echo "my-application Restart!"
echo $1

# 서버 실행
nohup java -jar build/libs/WinterProject2024-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev > /dev/null 2>&1 &
</code></pre>
</details>

<details>
    <summary>2번 deploy.sh 코드</summary>

deploy.sh<br>
``실행 중인 서버 종료``, ``GitHub에서 수정 사항 업데이트``, ``gradlew build 실행``, ``restart.sh 실행``을 자동으로 할 수 있게 코드를 추가했습니다.
<pre><code>
#!/bin/bash

# 실행 중이던 서버 종료
echo "Stopping current server..."
ps -ef | grep "WinterProject2024-0.0.1-SNAPSHOT.jar" | grep -v grep | awk '{print $2}' | xargs kill -9 2> /dev/null

if [ $? -eq 0 ]; then
    echo "Server stopped successfully."
else
    echo "!!! No running server found."
fi

echo "Pulling latest code..."
git pull origin main
if [ $? -ne 0 ]; then
    echo "!!! Failed to pull latest code."
    exit 1
fi

# Gradle 빌드
echo "Building the project..."
./gradlew build > build.log 2>&1

if [ $? -ne 0 ]; then
    echo "!!! Build failed. Check build.log for details."
    exit 1
fi

# 서버 실행
echo "Starting the new server..."
nohup java -jar build/libs/WinterProject2024-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev > app.log 2>&1 &

# 서버 시작 상태 확인
if [ $? -eq 0 ]; then
    echo "Server started successfully. Logs can be found in app.log."
else
    echo "!!! Failed to start the server. Check app.log for more details."
fi
</code></pre>
</details>

## 디버깅 과정
<details>
    <summary>DB 데이터 저장 실패</summary>

**app.log**에 `Initiating transaction rollback`, `Rolling back JPA transaction on EntityManager [SessionImpl(1781951903<open>)]`, `rolling back`이라는 문장이 있었고 ``Hibernate``가 ``트랜잭션``을 ``롤백``했다는 사실을 알 수 있었다.

그래서 User의 Entity가 정의된 User.java를 확인했고 테이블의 이름이 MySQL의 예약어인 `User`인게 문제였다.

결론적으로 User.java에 어노테인션 `@Table(name = "users")`를 추가하여 문제를 해결했다.

</details>

<details>
    <summary>Iframe 연결 거부 </summary>

**Spring Boot**의 ``Security 의존성``을 사용하면 ``X-Frame-Options Click Jacking`` 공격을 막기 위해 자동으로 ``DENY(Iframe 비허용)``으로 돼 있어 연결 거부에러가 발생했다.

그래서 ``SecurityConfig.java``의 ``SecurityFilterChain`` 코드에  
``.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))``를 추가하여 연결 거부 문제를 해결 했다.

※ ``Click Jacking``이란 웹 사용자가 자신이 클릭하고 있다고 인지하는 것과 다른 어떤 것을 클릭하게 속이는 악의적인 기법이다.
</details>

## 참고한 곳
<details open>
    <summary>스프링 부트</summary>

- [[Spring-Boot] Spring-boot 프로젝트 생성 / 빌드/ 실행](https://8156217.tistory.com/68)
- [[백엔드] 스프링 개발 입문 느낀점 및 요약 - yssgood.log](https://velog.io/@yssgood/%EB%B0%B1%EC%97%94%EB%93%9C-%EC%8A%A4%ED%94%84%EB%A7%81-%EA%B0%9C%EB%B0%9C-%EC%9E%85%EB%AC%B8-%EB%8A%90%EB%82%80%EC%A0%90-%EB%B0%8F-%EC%9A%94%EC%95%BD)
- [[Thymeleaf] 타임리프 문법 정리](https://makeaplayground.tistory.com/187)
- [Springboot 시작할때 APPLICATION FAILED TO START - 세폴리아](https://hsmang.tistory.com/22)
- [[스프링부트 4] Spring MVC Controller 만들기 1탄](https://shallow-learning.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-4-Spring-MVC-Controller-%EB%A7%8C%EB%93%A4%EA%B8%B0)
- [[Spring Boot] @PathVariable 사용법](https://so-easy-coding.tistory.com/8)
- [https://innovation123.tistory.com/54]([Spring Boot] @PathVariable과 @RequestParam - 파라미터)
</details>

<details open>
    <summary>JPA</summary>

- [[JPA] 2. 엔티티 매핑 @어노테이션 정리/예제](https://cjw-awdsd.tistory.com/46)
- [[JPA] 3. 엔티티 연관 관계 매핑 정리/예제](https://cjw-awdsd.tistory.com/47?category=806877)
- [[Java] Spring Boot - JPA @PrePersist, @PreUpdate 사용하기](https://blog.naver.com/seek316/223353802740)
- [[mariaDB] ERROR 1698 (28000): Access denied for user 'root'@'localhost' 문제 해결](https://velog.io/@hm5395/mariaDB-ERROR-1698-28000-Access-denied-for-user-rootlocalhost-%EB%AC%B8%EC%A0%9C-%ED%95%B4%EA%B2%B0)
- [[Spring Boot] 사용자 입력 데이터 DB 저장! (Feat. JPA)](https://velog.io/@wijoonwu/JPA)
- [Springboot 게시판 만들기 (4) - 게시글 작성 DB에 저장](https://baam-ki.tistory.com/29)
- [[JPA] JPARepository에 대해 알아보자(+사용법, Method)](https://velog.io/@minju0426/JPARepository%EC%97%90-%EB%8C%80%ED%95%B4-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90%EC%82%AC%EC%9A%A9%EB%B2%95-Method)
</details>

<details open>
    <summary>Spring Security6</summary>

- [Spring Security6 - Authentication(인증)](https://curiousjinan.tistory.com/entry/Spring-Security6-Authentication%EC%9D%B8%EC%A6%9D)
- [3-07 로그인과 로그아웃 기능 구현하기](https://wikidocs.net/162255#_1)
- [[Spring Security] H2 연결 안되는 에러](https://gyeongsuuuu.tistory.com/65)
- [[Spring Security] x-frame-option 헤더 설정(iframe)](https://lucas-owner.tistory.com/69)
- [https://velog.io/@pig426/Spring-Principal-%EA%B0%9D%EC%B2%B4]([Spring] Principal 객체)
</details>

<details open>
    <summary>MySQL</summary>

- [EC2 Ubuntu 인스턴스 생성부터 Java, Mysql 설치 및 외부접속하기](https://dev-chw.tistory.com/32)
- [aws ec2 인스턴스(우분투 서버)에 MySQL Workbench 연동](https://bj-turtle.tistory.com/35)
- [MySQL Workbench로 ERD다이어그램 생성](https://velog.io/@psj0810/MySQL-Workbench%EB%A1%9C-ERD%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A8-%EC%83%9D%EC%84%B1)
- [MySQL Workbench - ERD 추출하여 그리기, 추출된 ERD를 이미지로 저장하기](https://luvris2.tistory.com/903)
- [VARCHAR vs TEXT](https://medium.com/daangn/varchar-vs-text-230a718a22a1)
- [[Ubuntu] Ubuntu20.04 에서 Mysql 외부접속 허용하기](https://yoshikixdrum.tistory.com/217)
</details>

<details open>
    <summary>리눅스/우분투(Linux/Ubuntu)</summary>

- [[Linux / ubuntu] AWS Ubuntu 20.04에 swap 메모리 설정하기, Freetier 메모리 부족 현상 해결](https://innovation123.tistory.com/200)
</details>

<details open>
    <summary>etc</summary>

- [TIL 29. 정규표현식(e-mail, password 유효성)](https://velog.io/@fall031/%EC%A0%95%EA%B7%9C%ED%91%9C%ED%98%84%EC%8B%9D)
- ChatGPT
</details>

<details>
    <summary>AWS(Amazone Web Service)</summary>

- [[배포] AWS를 통한 배포 방법 알아보기(인스턴스 생성과 연결)](https://kang-james.tistory.com/entry/%EB%B0%B0%ED%8F%AC-AWS%EB%A5%BC-%ED%86%B5%ED%95%9C-%EB%B0%B0%ED%8F%AC-%EB%B0%A9%EB%B2%95-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4-%EC%83%9D%EC%84%B1%EA%B3%BC-%EC%97%B0%EA%B2%B0)
- [[배포] AWS를 통한 배포 방법 알아보기(EC2 서버 실행)](https://kang-james.tistory.com/entry/%EB%B0%B0%ED%8F%AC-AWS%EB%A5%BC-%ED%86%B5%ED%95%9C-%EB%B0%B0%ED%8F%AC-%EB%B0%A9%EB%B2%95-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0EC2-%EC%84%9C%EB%B2%84-%EC%8B%A4%ED%96%89)
- [[AWS] 인스턴스 SSH 접속 오류](https://support.bespinglobal.com/ko/support/solutions/articles/73000615454--aws-%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4-ssh-%EC%A0%91%EC%86%8D-%EC%98%A4%EB%A5%98)
- [[AWS] EC2 인스턴스를 시작하거나 실행할 때 발생하는 InsufficientInstanceCapacity 오류](https://support.bespinglobal.com/ko/support/solutions/articles/73000615454--aws-%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4-ssh-%EC%A0%91%EC%86%8D-%EC%98%A4%EB%A5%98)
- [AWS EC2에 Tomcat 서버 연결 및 오류 해결 과정 (Tomcat, 서버 충돌, 보안그룹, RDS)](https://wing-beat.tistory.com/177)
</details>

