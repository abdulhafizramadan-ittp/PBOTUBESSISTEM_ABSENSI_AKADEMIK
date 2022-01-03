package com.pbo.tubes.view;

import com.pbo.tubes.model.user.Mahasiswa;
import com.pbo.tubes.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthView {

    private final Scanner scannerString = new Scanner(System.in);

    public User registerView() {
        System.out.println("\n----------------------------------------------------");
        System.out.println("Sistem registrasi mahasiswa akademik :");
        System.out.println("----------------------------------------------------");

        System.out.print("Masukan nama kamu : ");
        String name = scannerString.nextLine();

        System.out.print("Masukan email kamu : ");
        String email = scannerString.nextLine();

        System.out.print("Masukan password kamu : ");
        String password = scannerString.nextLine();

        return new Mahasiswa(name, email, password);
    }

    public void registerSuccessView() {
        System.out.println("\nRegistrasi berhasil, silahkan login untuk mengakses halaman dashboard anda!");
        System.out.print("Enter untuk Keluar..");
        scannerString.nextLine();
    }

    public void registerFailedView() {
        System.out.println("Registrasi gagal, silahkan coba lagi!");
    }

    public List<String> loginView() {
        System.out.println("\n----------------------------------------------------");
        System.out.println("Selamat datang di sistem absensi akademik, \nsilahkan masukan email dan password untuk login!");
        System.out.println("----------------------------------------------------");

        System.out.print("Email : ");
        String email = scannerString.nextLine();
        System.out.print("Password : ");
        String password = scannerString.nextLine();

        List<String> loginRequest = new ArrayList<>();
        loginRequest.add(email);
        loginRequest.add(password);

        return loginRequest;
    }

    public void loginFailedView() {
        System.out.println("\nUsername atau password kamu salah!");
        System.out.print("Enter untuk Keluar..");
        scannerString.nextLine();
    }

    public boolean logoutView() {
        System.out.println("\n----------------------------------------------------");
        System.out.println("Apakah kamu yakin ingin keluar");
        System.out.println("----------------------------------------------------");

        System.out.println("1. yes");
        System.out.println("0. no");

        String menu;

        do {
            System.out.print("Masukan menu : ");
            menu = scannerString.next();

            if (!(menu.equals("0") || menu.equals("1"))) {
                System.out.println("Menu tidak ditemukan\n");
            } else {
                break;
            }
        } while (true);

        return "1".equals(menu);
    }
}
