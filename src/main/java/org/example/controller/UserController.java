package org.example.controller;

import org.example.util.ScannerUtil;
import org.springframework.stereotype.Controller;
@Controller
public class UserController {
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
    }
    private void bookList() {
    }
    public void showMenu() {
        System.out.println("<<<WELCOME TO USER MENU!>>>");
        System.out.println("*** USER MENU ***");
        System.out.println("1. Book list (Kitoblar)");
        System.out.println("2. Take book (Kitob olish)");
        System.out.println("3. Taken book (Olib qaytarilmagan kitoblar)");
        System.out.println("4. Return book (Qaytarilgan kitoblar)");
        System.out.println("5. History library (Kutubxona tarixi)");
        System.out.println("6. Oder book (Kutubxonchi yoq kitobni olib kel deb buyurishi)");
        System.out.println("0. Log Out");
    }
}