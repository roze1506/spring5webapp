package guru.springframework.spring5webapp.domains;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author(){}

    public Author(String name) {
        this.name = name;
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

    public Set<Book> getBooks() {
        return new HashSet<>(this.books);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Author) {
            return this.id.equals(((Author) obj).id);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Book{" + "id: " + this.id + ", name: " + this.name + "}";
    }
}
