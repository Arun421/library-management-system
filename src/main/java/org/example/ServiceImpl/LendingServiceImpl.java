package org.example.ServiceImpl;

import org.example.Model.Book;
import org.example.Model.Patron;
import org.example.Service.LendingService;

public class LendingServiceImpl implements LendingService {
    private Library library;
    public LendingServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public void checkoutBook(String patronId, String ISBN) {
        Patron patron = library.findPatron(patronId);
        Book book = library.findBook(ISBN);

        if (patron == null || book ==null){
            System.out.println("Invalid Patron or Book.");
            return;
        }
        if (!book.isAvailable()){
            System.out.println("Book is not available.");
            return;
        }
        patron.borrowBook(book);
        System.out.println(patron.getName()+" Borrowed "+book.getTitle());
    }

    public void returnBook(String patronId, String ISBN) {
        Patron patron = library.findPatron(patronId);
        Book book = library.findBook(ISBN);

        if (patron == null || book ==null){
            System.out.println("Invalid Patron or Book.");
            return;
        }
        if (!patron.getBorrowedBooks().contains(book)){
            System.out.println("This book was not borrowed by the patron.");
            return;
        }
        patron.returnBook(book);
        System.out.println(patron.getName()+" Returned "+book.getTitle());
    }
}
