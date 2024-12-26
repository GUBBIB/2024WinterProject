# 2024 겨울방학 간단한 프로젝트

## 페이지 링크
- AWS 배포 페이지 
[메인 페이지 - 서버 연결 O](http://ec2-16-16-201-86.eu-north-1.compute.amazonaws.com:8081/)
- 서버 연결 안한 페이지
[메인 페이지 - 서버 연결 X](https://gubbib.github.io/2024WinterProject/WinterProject2024/src/main/resources/static/index.html)

## 기간
- 2024년 12월 25일 ~ ####년 ##월 ##일

## 프로젝트 설명
이 프로젝트는 Spring Boot를 사용하여 로그인, 회원가입, 게시판 기능을 구현한 웹 페이지입니다.
회원가입 후 로그인을 통해서 게시글 작성 및 댓글을 작하고 관리할 수 있습니다.

## 기술 스택
- **Backend**: Spring Boot
- **Frontend**: HTMl, CSS, JavaScript, Thymeleaf
- **DataBase**: MySQL
- **IDE**: IntelliJ IDEA
- **Cloud Service**: [AWS - Ubuntu](https://eu-north-1.console.aws.amazon.com/ec2/home?region=eu-north-1#Home:)

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
- Validatio(Optional) <br>
입력 값이 올바른지 확인하기 위해 추가했습니다.
- Lombok <br>
Getter, Setter와 같이 반복적인 Java 코드를 줄이기 위해 추가했습니다.

## 페이지 뷰
- 메인/로그인 페이지
![메인/로그인 페이지](https://github.com/user-attachments/assets/d5c5ea96-b506-4900-9ebd-0bab7e5cac35)
- 회원가입 페이지
![회원가입 페이지](https://github.com/user-attachments/assets/e1d2c34f-286c-439d-8cb3-039ac49d9a99)

## 추가 사항
- 포트 충돌로 인해서 포트번호를 8081로 변경
- resetart.sh<br>
``백그라운드로 서버``를 돌릴 수 있게 코드를 추가했습니다.
<pre><code>
#!/bin/bash

ps -ef | grep "WinterProject2024-0.0.1-SNAPSHOT.jar" | grep -v grep | awk '{print $2}' | xargs kill -9 2> /dev/null

if [ $? -eq 0 ];then
    echo "my-application Stop Success"
else
    echo "my-application Not Running"
fi

echo "my-application Restart!"
echo $1
nohup java -jar build/libs/WinterProject2024-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev > /dev/null 2>&1 &
</code></pre>

- deploy.sh<br>
``실행 중인 서버 종료``, ``GitHub에서 수정 사항 업데이트``, ``gradlew build 실행``, ``restart.sh 실행``을 자동으로 할 수 있게 코드를 추가했습니다.
<pre><code>
#!/bin/bash

echo "Stopping current server..."
pkill -f 'java -jar'

echo "Pulling latest code..."
git pull origin main

echo "Building the project..."
./gradlew build

echo "Starting the new server..."
./restart.sh

echo "Deployment complete. Logs can be found in app.log."
</code></pre>

## 추가할 기능
- 스트링 부트 파일 생성 ( 2024-12-25 완료 )
- 로그인 페이지 작성 ( 2024-12-25 완료 )
- 웹 어플리케이션 호스팅 ( 2024-12-25 완료 )
- 회원가입 페이지 작성 ( 2024-12-26 완료)
- 게시판 페이지 작성
- ERD 설계 및 DB 연결
- Admin 계정 생성(모든 게시글, 댓글 삭제 가능)

## 참고한 곳
- [[Spring-Boot] Spring-boot 프로젝트 생성 / 빌드/ 실행](https://8156217.tistory.com/68)
- [[백엔드] 스프링 개발 입문 느낀점 및 요약 - yssgood.log](https://velog.io/@yssgood/%EB%B0%B1%EC%97%94%EB%93%9C-%EC%8A%A4%ED%94%84%EB%A7%81-%EA%B0%9C%EB%B0%9C-%EC%9E%85%EB%AC%B8-%EB%8A%90%EB%82%80%EC%A0%90-%EB%B0%8F-%EC%9A%94%EC%95%BD)
- [[Spring Boot] 타임리프(Thymeleaf) - 유광진](https://velog.io/@kwangjin5468/Thymeleaf)
- [Springboot 시작할때 APPLICATION FAILED TO START - 세폴리아](https://hsmang.tistory.com/22)
- [[배포] AWS를 통한 배포 방법 알아보기(인스턴스 생성과 연결)](https://kang-james.tistory.com/entry/%EB%B0%B0%ED%8F%AC-AWS%EB%A5%BC-%ED%86%B5%ED%95%9C-%EB%B0%B0%ED%8F%AC-%EB%B0%A9%EB%B2%95-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4-%EC%83%9D%EC%84%B1%EA%B3%BC-%EC%97%B0%EA%B2%B0)
- [[배포] AWS를 통한 배포 방법 알아보기(EC2 서버 실행)](https://kang-james.tistory.com/entry/%EB%B0%B0%ED%8F%AC-AWS%EB%A5%BC-%ED%86%B5%ED%95%9C-%EB%B0%B0%ED%8F%AC-%EB%B0%A9%EB%B2%95-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0EC2-%EC%84%9C%EB%B2%84-%EC%8B%A4%ED%96%89)
- [[AWS] 인스턴스 SSH 접속 오류](https://support.bespinglobal.com/ko/support/solutions/articles/73000615454--aws-%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4-ssh-%EC%A0%91%EC%86%8D-%EC%98%A4%EB%A5%98)
- [[AWS] EC2 인스턴스를 시작하거나 실행할 때 발생하는 InsufficientInstanceCapacity 오류](https://support.bespinglobal.com/ko/support/solutions/articles/73000615454--aws-%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4-ssh-%EC%A0%91%EC%86%8D-%EC%98%A4%EB%A5%98)
- [AWS EC2에 Tomcat 서버 연결 및 오류 해결 과정 (Tomcat, 서버 충돌, 보안그룹, RDS)](https://wing-beat.tistory.com/177)
- ChatGPT