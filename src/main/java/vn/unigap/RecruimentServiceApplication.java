package vn.unigap;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import java.util.TimeZone;

@SpringBootApplication

public class RecruimentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruimentServiceApplication.class, args);
	}


}
