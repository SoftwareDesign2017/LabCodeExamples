package bookStore;

import bookStore.repository.AuthorRepository;
import bookStore.service.AuthorService;
import bookStore.service.AuthorServiceImpl;
import bookStore.service.CachingAuthorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Catalysts on 8/9/2015.
 */

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"bookStore.repository"})
@PropertySource(value = "classpath:application.properties")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "AuthorService")
    public AuthorService authorService(AuthorRepository repository) {
        return new CachingAuthorService(new AuthorServiceImpl(repository));
    }
}
