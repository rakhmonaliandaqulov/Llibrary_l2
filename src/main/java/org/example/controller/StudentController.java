package org.example.controller;

import org.example.dto.Student;
import org.example.service.BookService;
import org.example.service.StudentsBookService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class StudentController {
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentsBookService studentsBookService;
    public void start() {
        boolean b = true;
        while (b) {
            showMenu();
            switch (ScannerUtil.getAction()) {
                case 1 -> bookList();
                case 2 -> takeBook();
                case 3 -> takenBook();
                case 4 -> returnBook();
                case 5 -> historyLibrary();
                case 6 -> orderBook();
                case 0 -> b = false;
                default -> {
                    System.out.println("Are you mazgi? Write correctly!");
                    showMenu();
                }
            }
        }
    }
    private void orderBook() {
    }
    private void historyLibrary() {
    }
    private void returnBook() {
    }
    private void takenBook() {

    }
    private void takeBook() {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book id: ");
        Integer id = scanner.nextInt();

        System.out.print("Enter duration (necha kun?): ");
        Integer duration = scanner.nextInt();

        studentsBookService.takeBook(id, duration, student);
    }
    private void bookList() {
        bookService.bookList();
    }
    public void showMenu() {
        System.out.println("<<<WELCOME TO USER MENU!>>>");
        System.out.println("*** USER MENU ***");
        System.out.println("1. Book list (Kitoblar)");
        System.out.println("2. Take book (Kitob olish)");
        System.out.println("3. Taken book (Olib qaytarilmagan kitoblar)");
        System.out.println("-------------------------------------------------");
        System.out.println("4. Return book (Qaytarilgan kitoblar)");
        System.out.println("5. History library (Kutubxona tarixi)");
        System.out.println("6. Oder book (Kutubxonchi yoq kitobni olib kel deb buyurishi)");
        System.out.println("--------------------------------------------------");
        System.out.println("0. Log Out");
    }
}