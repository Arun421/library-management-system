package org.example.Service;

import org.example.Model.Book;
import org.example.Model.Patron;

import java.util.List;

public interface PatronManagement {
    void addPatron(Patron patron);
    void updatePatron(Patron patron);
    List<Book> getBorrowHistory(String patronId);
}
