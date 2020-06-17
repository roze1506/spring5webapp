package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domains.Author;
import guru.springframework.spring5webapp.domains.Book;
import guru.springframework.spring5webapp.domains.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author mike = new Author("Mike Tyson");
        Book ut = new Book("Undisputed Truth", "4335646");
        Publisher publisher = new Publisher("LEFTHOOKBV", "BLADIEBLA 20", "Leeuwarden", "Friesland"
                , "55758054JR");

        publisherRepository.save(publisher);
        authorRepository.save(mike);
        bookRepository.save(ut);

        mike.addBook(ut);
        ut.addAuthor(mike);
        publisher.addBook(ut);
        ut.setPublisher(publisher);

        bookRepository.save(ut);
        authorRepository.save(mike);

        Author thomas = new Author("Thomas Hauser");
        Book ma = new Book("Muhammad Ali: His Live and Times", "6545446");
        thomas.addBook(ma);
        ma.addAuthor(thomas);
        publisher.addBook(ma);
        ma.setPublisher(publisher);

        authorRepository.save(thomas);
        bookRepository.save(ma);
        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap! :D");
        System.out.println("Number of authors added: " + authorRepository.count());
        System.out.println("Number of books added: " + bookRepository.count());
        System.out.println("Started in BootStrap! :D");
        System.out.println("Number of publishers added: " + publisherRepository.count());
        System.out.println(publisher);
    }
}
