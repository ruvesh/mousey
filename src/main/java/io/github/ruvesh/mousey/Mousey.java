package io.github.ruvesh.mousey;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Mousey {

	/**
	 * Running the application with SpringApplicationBuilder
	 * instead of SpringApplication.run(Mousey.class, args) to set headless=false,
	 * to avoid java awt headless exception
	 * @param args command-line args
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(Mousey.class)
								.headless(false)
								.run(args);
	}

}
