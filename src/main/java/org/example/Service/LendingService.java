package org.example.Service;

public interface LendingService {
    void checkoutBook(String patronId, String ISBN);
    void returnBook(String patronId, String ISBN);
}
