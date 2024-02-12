package com.kosign.dev;

import com.kosign.dev.utils.PasswordUtils;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan("com.kosign.dev.properties")
public class NextApiSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextApiSampleApplication.class, args);
	}
	@Bean
	ApplicationRunner runner() {
		return args -> {
			System.out.println(PasswordUtils.encrypt("321"));
		};
	}
}
