package guru.springframework.spring5webapp.domains;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    private String city;

    private String state;

    private String zip;

    @OneToMany
    @JoinColumn(columnDefinition="publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher(){}

    public Publisher(String name, String address, String city, String state, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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
        if(obj instanceof Publisher) {
            return this.id.equals(((Publisher) obj).getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Publisher{id: " + this.id + ", name: " + this.name + ", adress: " + this.address + ", zip: " + this.zip
                + ", city: " + this.city + ", state: " + this.state + "}";
    }
}
