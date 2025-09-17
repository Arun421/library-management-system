package org.example.Service;

import org.example.Model.Book;

import java.util.List;

public interface BookManagement {
    void addBook(Book book);
    void removeBook(String isbn);
    void updateBook(Book updatedBook);
    List<Book> searchBooks(String keyword);
}
