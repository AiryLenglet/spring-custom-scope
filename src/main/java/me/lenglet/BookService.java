package me.lenglet;

import me.lenglet.scope.AppRequestScope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AppRequestScope
public class BookService {

    private final Book book;

    public BookService(Book book) {
        this.book = book;
    }

    public List<Book> books() {
        return List.of(book);
    }
}
