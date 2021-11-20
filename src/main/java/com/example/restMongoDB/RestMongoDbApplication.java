package com.example.restMongoDB;

import com.example.restMongoDB.model.Address;
import com.example.restMongoDB.model.Gender;
import com.example.restMongoDB.model.Resume;
import com.example.restMongoDB.repository.ResumeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RestMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestMongoDbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ResumeRepository repository){
		return args -> {
			Address address = new Address(
					"Russia",
					"Kazan"
			);
			Resume resume = new Resume(
					"Ivan",
					"Smirnov",
					21,
					Gender.MALE,
					"ivan_21@mail.ru",
					"programmer",
					address,
					"8 998 652 36 54",
					"12536",
					50000,
					"cool man"

			);

			repository.insert(resume);

		};
	}

}
