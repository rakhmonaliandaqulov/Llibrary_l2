package org.example.controller;

import org.example.util.ScannerUtil;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
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
    }
    private void studentList() {
    }
    private void deleteBook() {
    }
    private void addBook() {
    }
    private void bookList() {
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