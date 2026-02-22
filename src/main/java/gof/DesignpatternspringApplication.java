package gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesignpatternspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignpatternspringApplication.class, args);
	}

}
