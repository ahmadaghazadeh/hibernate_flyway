package com.sevensky.hibernate_intro.bootstrap;

import com.sevensky.hibernate_intro.domain.Author;
import com.sevensky.hibernate_intro.domain.Book;
import com.sevensky.hibernate_intro.repositories.AuthorRepository;
import com.sevensky.hibernate_intro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local","default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public DataInitializer(BookRepository bookRepository,AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        authorRepository.deleteAll();
        Author authorAhmad=new Author("Ahmad","Aghazadeh");

        Author authorAhmadSaved=authorRepository.save(authorAhmad);

        bookRepository.deleteAll();
        Book bookDDD=new Book("Domain Driven Design","123","RandomHouse",authorAhmadSaved);

        Book savedDDD=bookRepository.save(bookDDD);

        Book bookSIA=new Book("Spring in Action","123","RandomHouse",authorAhmadSaved);

        Book savedSIA=bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: "+book.getId());
            System.out.println("Book Name: "+book.getTitle());
        });

    }
}
