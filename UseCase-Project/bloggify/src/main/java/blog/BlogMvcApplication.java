package blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("blog.controllers")
@ComponentScan("blog.models")
@ComponentScan("blog.services")
public class BlogMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogMvcApplication.class, args);

	}

}
