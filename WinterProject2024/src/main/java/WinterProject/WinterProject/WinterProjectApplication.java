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

// BoardContent 타임리프문 수정 필요 
// 현재 post 저장 까지는 되는데 post를 들고 올 때 문제가 있는거 같음
// 문제점
// 1. 그냥 무작정 post를 다 긁어옴 
// ㄴ boardId에 맞는거만 들고오게 바꿔야 함