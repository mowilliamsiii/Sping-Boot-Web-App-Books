package com.moseswilliams.spring1webapp.bootstrap;

import com.moseswilliams.spring1webapp.domain.Author;
import com.moseswilliams.spring1webapp.domain.Book;
import com.moseswilliams.spring1webapp.domain.Publisher;
import com.moseswilliams.spring1webapp.repos.AuthorRepo;
import com.moseswilliams.spring1webapp.repos.BookRepo;
import com.moseswilliams.spring1webapp.repos.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    private final PublisherRepo publisherRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric  = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher publisher = new Publisher("Publisher","publisher Way","Pub City","PB","12345");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepo.save(eric);
        bookRepo.save(ddd);
        publisherRepo.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "546546684");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);


        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);


        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepo.save(rod);
        bookRepo.save(noEJB);
        publisherRepo.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of book: " + bookRepo.count());
        System.out.println(publisher);
        System.out.println("Number of publisher's books: " + publisher.getBooks().size());
        System.out.println(publisherRepo.count());

    }
}
