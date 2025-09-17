package org.example;

import org.example.Model.Book;
import org.example.Model.Patron;
import org.example.ServiceImpl.LendingServiceImpl;
import org.example.ServiceImpl.Library;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        LendingServiceImpl lendingService = new LendingServiceImpl(library);
        library.addBook(new Book( "The Great Gatsby", "F. Scott Fitzgerald","000",1925));
        library.addBook(new Book("Java Basics", "James Gosling", "111", 1995));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "222", 2008));
        library.addBook(new Book("Core Java", "Som Prakash Rai", "333", 2019));
        System.out.println("Books after adding: " + library.searchBooks(""));
        library.removeBook("333");
        System.out.println("Removed book with ISBN 333");
        System.out.println("Books after removal: " + library.searchBooks(""));
        Patron patron1 = new Patron("John Doe", "P001", "John@email.com");
        Patron patron2 = new Patron("Pawan Panjwani", "P002", "Pawan@email.com");
        library.addPatron(patron1);
        library.addPatron(patron2);
        Patron updatedPatron1 = new Patron("Dhawal Trivedi", "P001", "Dhawal@email.com");
        library.updatePatron(updatedPatron1);
        System.out.println("Patrons after update: " + patron1.getName() + ", " + patron2.getName());
        lendingService.checkoutBook("P001", "111");
        lendingService.checkoutBook("P002","222");
        lendingService.returnBook("P001","111");
        lendingService.returnBook("P001","000");

        Book updatedBook = new Book("Effective Java - 3rd Edition", "Joshua Bloch", "222", 2018);
        library.updateBook(updatedBook);

        System.out.println("Search Results:");
        library.searchBooks("Java").forEach(book -> System.out.println(book.getTitle()));

        System.out.println("Dhawal trivedi's Borrow History:"+ library.getBorrowHistory("P001"));
        System.out.println("Pawan panjwani's Borrow History:"+ library.getBorrowHistory("P002"));
    }
}