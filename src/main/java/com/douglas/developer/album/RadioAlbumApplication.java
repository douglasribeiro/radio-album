package com.douglas.developer.album;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@SpringBootApplication
@EntityScan({"com.douglas.developer.core.model"})
@EnableJpaRepositories({"com.douglas.developer.core.repository"})
@ComponentScan({"com.douglas.developer.core","com.douglas.developer.album"})
public class RadioAlbumApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadioAlbumApplication.class, args);
	}

}
