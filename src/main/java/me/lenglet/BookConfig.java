package me.lenglet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public Book book() {
        return new Book("47986", "test");
    }
}
