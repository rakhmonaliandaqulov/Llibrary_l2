package org.example.controller;

import org.example.dto.Student;
import org.example.service.BookService;
import org.example.service.StudentService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Scanner;

@Controller
public class AdminController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    public void  start() {
        boolean b = true;
        while (b) {
            showMenu();
            switch (ScannerUtil.getAction()) {
            case 1 -> bookList();
            case 2 -> addBook();
            case 3 -> deleteBook();
            case 4 -> studentList();
            case 5 -> addStudent();
            case 6 -> deleteStudent();
            case 7 -> studentTakenBook();
            case 8 -> bookTakenHistory();
            }
        }
    }
    private void bookTakenHistory() {
    }
    private void studentTakenBook() {
    }
    private void deleteStudent() {
    }
    private void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter birth date: ");
        String birthDate = scanner.nextLine();

        studentService.addStudent(name, surname, phone, birthDate);
    }
    private void studentList() {
    }
    private void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book id: ");
        Integer bookId = scanner.nextInt();

        bookService.deleteBook(bookId);
    }
    private void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        System.out.print("Enter publish year: ");
        String publish_year = scanner.nextLine();

        System.out.print("Enter amount: ");
        Integer amount = scanner.nextInt();

        bookService.addBook(title, author, publish_year, amount);
    }
    private void bookList() {
        bookService.bookList();
    }
    public void showMenu() {
        System.out.println("*** WELCOME TO ADMIN MENU ***");
        System.out.println("1. Book list");
        System.out.println("2. Add book");
        System.out.println("3. Delete book");
        System.out.println("4. Student List");
        System.out.println("5. Add student");
        System.out.println("6. Delete student");
        System.out.println("7. Student taken book");
        System.out.println("8. Book taken history");
    }
}