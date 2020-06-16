package guru.springframework.spring5webapp.domains;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String isbn;
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(columnDefinition=" book_id"),
            inverseJoinColumns = @JoinColumn(columnDefinition = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(){}

    public Book(String name, String isbn) {
        this.name = name;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return new HashSet<>(this.authors);
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book) {
            return this.id.equals(((Book) obj).id);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Book{" + "id: " + this.id + ", name: " + this.name + ", isbn: " + this.isbn + "}";
    }
}

