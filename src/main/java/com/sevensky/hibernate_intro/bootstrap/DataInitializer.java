package com.sevensky.hibernate_intro.bootstrap;

import com.sevensky.hibernate_intro.domain.Author;
import com.sevensky.hibernate_intro.domain.AuthorUuid;
import com.sevensky.hibernate_intro.domain.Book;
import com.sevensky.hibernate_intro.domain.BookUuid;
import com.sevensky.hibernate_intro.domain.compose.AuthorCompose;
import com.sevensky.hibernate_intro.domain.compose.AuthorEmbedded;
import com.sevensky.hibernate_intro.domain.compose.NameId;
import com.sevensky.hibernate_intro.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local","default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorComposeRepository authorComposeRepository;
    private final AuthorEmneddedRepository authorEmneddedRepository;
    private final AuthorUuidRepository authorUuidRepository;
    private final BookUuidRepository bookUuidRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, AuthorComposeRepository authorComposeRepository, AuthorEmneddedRepository authorEmneddedRepository, AuthorUuidRepository authorUuidRepository, BookUuidRepository bookUuidRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.authorComposeRepository = authorComposeRepository;
        this.authorEmneddedRepository = authorEmneddedRepository;
        this.authorUuidRepository = authorUuidRepository;
        this.bookUuidRepository = bookUuidRepository;
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

        AuthorUuid authorUuid=new AuthorUuid("First","Last");
        AuthorUuid authorUuidSaved=authorUuidRepository.save(authorUuid);
        System.out.println("Author "+authorUuidSaved.getId());


        BookUuid bookUuid=new BookUuid("First","Last","Ahmad");
        BookUuid bookUuidSaved=bookUuidRepository.save(bookUuid);
        System.out.println("Book "+bookUuidSaved.getId());

        AuthorCompose authorCompose=new AuthorCompose("First","Last");
        AuthorCompose authorComposeSaved=authorComposeRepository.save(authorCompose);
        System.out.println("AuthorCompose "+authorComposeSaved.getFirstName() + " " + authorComposeSaved.getLastName());

        AuthorEmbedded authorEmbedded=new AuthorEmbedded(new NameId("First","Last"));
        AuthorEmbedded authorEmbeddedSaved=authorEmneddedRepository.save(authorEmbedded);
        System.out.println("AuthorCompose "+authorEmbeddedSaved.getNameId().getFirstName() + " " + authorEmbeddedSaved.getNameId().getLastName() );
    }
}
