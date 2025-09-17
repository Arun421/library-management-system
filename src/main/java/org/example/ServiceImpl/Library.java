package org.example.ServiceImpl;

import org.example.Model.Book;
import org.example.Model.Patron;
import org.example.Service.BookManagement;
import org.example.Service.PatronManagement;

import java.util.ArrayList;
import java.util.List;

public class Library implements BookManagement, PatronManagement {
    private List<Book> books = new ArrayList<>();
    private List<Patron> patrons = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("Book with ISBN " + isbn + " removed.");
    }
    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(updatedBook.getIsbn())) {
                books.set(i, updatedBook);
                System.out.println("Book updated: " + updatedBook.getTitle());
                return;
            }
        }
    }

//    public List<Book> searchBooks(String keyword) {
//        List<Book> results = new ArrayList<>();
//        for (Book book : books) {
//            if (book.getTitle().contains(keyword) ||
//                book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
//                book.getIsbn().toLowerCase().contains(keyword.toLowerCase())) {
//                results.add(book);
//            }
//        }
//        return results;
//    }

    public List<Book> searchBooks(String keyword) {
        return books.stream()
                .filter(b -> b.getTitle().contains(keyword) ||
                        b.getAuthor().contains(keyword) ||
                        b.getIsbn().equals(keyword))
                .toList();

    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Patron added: " + patron.getName());
    }

    public void updatePatron(Patron updatedPatron) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getPatronId().equals(updatedPatron.getPatronId())) {
                patrons.set(i, updatedPatron);
                System.out.println("Patron updated: " + updatedPatron.getName());
                return;
            }
        }
    }
    public List<Book> getBorrowHistory(String patronId) {
        return patrons.stream()
                .filter(p -> p.getPatronId().equals(patronId))
                .findFirst()
                .map(Patron::getBorrowedBooks)
                .orElse(new ArrayList<>());
    }
    public Book findBook(String ISBN) {
        return books.stream()
                .filter(b -> b.getIsbn()
                .equals(ISBN))
                .findFirst()
                .orElse(null);
    }

    public Patron findPatron(String patronId) {
        return patrons.stream()
                .filter(p -> p.getPatronId().equals(patronId))
                .findFirst()
                .orElse(null);
    }
}
