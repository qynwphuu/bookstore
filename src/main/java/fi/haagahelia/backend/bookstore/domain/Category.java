package fi.haagahelia.backend.bookstore.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Book> books;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;


    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {return books;}
    public void setBooks(List<Book> books) {this.books = books;}
    public String getName () {return name;}
    public void setName (String name) {this.name = name;}
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

}

