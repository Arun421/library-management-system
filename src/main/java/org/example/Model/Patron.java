package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String patronId;
    private String email;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Patron(String name, String patronId, String email) {
        this.name = name;
        this.patronId = patronId;
        this.email = email;
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // when a patron borrows a book, it is marked as unavailable
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setAvailable(false);
    }

    // when a patron returns a book, it is marked as available
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
    }
}
