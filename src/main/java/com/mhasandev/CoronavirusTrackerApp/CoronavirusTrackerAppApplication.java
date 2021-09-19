package com.mhasandev.CoronavirusTrackerApp;

import com.mhasandev.CoronavirusTrackerApp.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronavirusTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusTrackerAppApplication.class, args);
	}

}
