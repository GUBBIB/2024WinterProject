package WinterProject.WinterProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class WinterProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WinterProjectApplication.class, args);
	}

}

// 추가해야할 기능 들

// 게시판 수정 기능
// 댓글 기능
// 채팅 기능
// 게시글 읽으면 조회수 증가 기능