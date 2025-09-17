# 📚 Library Management System

## 📌 Overview
This is a **Library Management System** implemented in **Java** using **Maven**.  
It demonstrates **OOP concepts**, **SOLID principles**, and design patterns.  
The system allows librarians to manage books, patrons, and the lending process efficiently.

---

## 🚀 Features
### ✅ Core Requirements
- **Book Management**
  - Add, remove, update books
  - Search books by title, author, or ISBN
- **Patron Management**
  - Add and update patrons
  - Track borrowing history
- **Lending Process**
  - Book checkout and return
- **Inventory Management**
  - Track available and borrowed books

---

## 🏗 Project Structure
```
src/
 └── main/
     ├── java/
     │   └── com.example.library/
     │       ├── model/        # Book, Patron
     │       ├── service/      # Interfaces (BookManagement, PatronManagement, LendingService)
     │       ├── service/impl/ # Implementations (Library, LendingServiceImpl)
     │       └── Main.java     # Demo class
     └── resources/
```

---

## ⚙️ Requirements
- Java 17+
- Maven 3.8+
- IntelliJ IDEA (or any Java IDE)

---

## ▶️ How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/library-management-system.git
   ```
2. Navigate into the project folder:
   ```bash
   cd library-management-system
   ```
3. Build with Maven:
   ```bash
   mvn clean install
   ```
4. Run the program:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.library.Main"
   ```

---

## 🧪 Example Usage
```text
=== Library Management System ===
Adding books...
Adding patrons...
Searching for books by author...
Checking out and returning books...
Displaying borrowing history...
```

## ✨ Technologies & Concepts
- Java (OOP, SOLID)
- Maven
- Design Patterns (Factory, Strategy, Observer)

## 📖 UML Diagram (ASCII)
                  +----------------+
                  |    <<interface>>|
                  |   BookService   |
                  +-----------------+
                  | + addBook(b:Book):void
                  | + removeBook(isbn:String):void
                  | + updateBook(b:Book):void
                  | + searchBook(query:String):List<Book>
                  +-----------------+
                          ^
                          |
                          |
                  +----------------+
                  |    <<interface>>|
                  |  PatronService  |
                  +-----------------+
                  | + addPatron(p:Patron):void
                  | + updatePatron(p:Patron):void
                  | + getBorrowHistory(pid:String):List<Book>
                  +-----------------+
                          ^
                          |
                          |
           +-----------------------------------+
           |             Library               |
           +-----------------------------------+
           | - books:List<Book>                |
           | - patrons:List<Patron>            |
           +-----------------------------------+
           | + addBook(b:Book):void            |
           | + removeBook(isbn:String):void    |
           | + updateBook(b:Book):void         |
           | + searchBook(q:String):List<Book> |
           | + addPatron(p:Patron):void        |
           | + updatePatron(p:Patron):void     |
           | + getBorrowHistory(pid:String):   |
           |   List<Book>                      |
           +-----------------------------------+
                          ^
                          |
           +-----------------------------------+
           |        <<interface>>               |
           |        LendingService              |
           +-----------------------------------+
           | + checkoutBook(pid:String, isbn:  |
           |   String):boolean                  |
           | + returnBook(pid:String, isbn:    |
           |   String):boolean                  |
           +-----------------------------------+
                          ^
                          |
           +-----------------------------------+
           |     LendingServiceImpl             |
           +-----------------------------------+
           | - library:Library                  |
           +-----------------------------------+
           | + checkoutBook(...):boolean        |
           | + returnBook(...):boolean          |
           +-----------------------------------+
              +------------------+
              |       Main       |
              +------------------+
              | + main(args[])   |
              +------------------+
              | (uses Library &  |
              | LendingServiceImpl|
              | to demo methods) |
              +------------------+

---

## 👨‍💻 Author
- Arun Kumar
