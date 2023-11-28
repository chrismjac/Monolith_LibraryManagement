package com.edureka.libraryManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "author")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="author_book",
            joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id",referencedColumnName = "id"))
    private List<Book> books = new ArrayList<>();
    public void addBook(Book book){
        if(this.books ==null){
            this.books = new ArrayList<>();
        }
        this.books.add(book);
    }
    public void removeBook(Long bookId){
        Book book = this.books.stream().filter(t-> Objects.equals(t.getId(), bookId)).findFirst().orElse(null);
        if(null !=book){
            this.books.remove(book);
            book.getAuthors().remove(this);
        }
    }
}
