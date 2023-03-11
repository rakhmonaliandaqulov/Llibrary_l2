package org.example.controller;

import org.example.util.ScannerUtil;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class LoginController {
    private String menu = """
            *** MENU ***
            1. Login
            0. Exit
            """;
    public void start() {
        boolean b = true;
        while (b) {
            System.out.println(menu);
            switch (ScannerUtil.getAction()) {
                case 1 -> getLogin();
                case 0 -> {
                    System.out.println("Programm finished!");
                    b = false;
                }
                default -> {
                    System.out.println("Are you mazgi? Write correctly!");
                    start();
                }
            }
        }
    }
    private void getLogin() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter phone:");
            String phone = scanner.nextLine();

            System.out.print("Enter pswd:");
            String password = scanner.next();

           // authSe.login(phone, password);
    }
}
