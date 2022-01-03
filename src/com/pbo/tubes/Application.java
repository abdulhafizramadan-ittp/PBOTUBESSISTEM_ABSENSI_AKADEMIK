package com.pbo.tubes;

import com.pbo.tubes.controller.auth.AuthController;
import com.pbo.tubes.controller.auth.AuthControllerImpl;
import com.pbo.tubes.model.Menu;
import com.pbo.tubes.model.user.User;
import com.pbo.tubes.view.AuthView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private final static List<User> userList = new ArrayList<>();

    private final static Scanner scannerString = new Scanner(System.in);

    public static void main(String[] args) {

        AuthView authView = new AuthView();
        AuthController authController = new AuthControllerImpl(userList, authView);

        do {
            Menu homeMenu = homeMenu();

            switch (homeMenu) {
                case REGISTER:
                    authController.register();
                    break;
                case LOGIN:
                    authController.login();
                    break;
                case EXIT:
                    authController.exit();
            }
        } while (true);
    }

    private static Menu homeMenu() {
        System.out.println("\n----------------------------------------------------");
        System.out.println("Selamat datang di sistem absensi akademik");
        System.out.println("----------------------------------------------------");

        System.out.println("Silahkan pilih menu :");
        System.out.println("1. " + Menu.REGISTER);
        System.out.println("2. " + Menu.LOGIN);
        System.out.println("0. " + Menu.EXIT);

        String menu;

        do {
            System.out.print("Masukan menu : ");
            menu = scannerString.next();

            if (!(menu.equals("0") || menu.equals("1") || menu.equals("2"))) {
                System.out.println("Menu tidak ditemukan, coba lagi!!");
            } else {
                break;
            }
        } while (true);

        switch (menu) {
            case "1":
                return Menu.REGISTER;
            case "2":
                return Menu.LOGIN;
            default:
                return Menu.EXIT;
        }
    }
}
