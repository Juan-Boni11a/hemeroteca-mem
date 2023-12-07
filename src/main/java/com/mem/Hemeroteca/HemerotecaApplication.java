package com.mem.Hemeroteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class HemerotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HemerotecaApplication.class, args);

	}

}
