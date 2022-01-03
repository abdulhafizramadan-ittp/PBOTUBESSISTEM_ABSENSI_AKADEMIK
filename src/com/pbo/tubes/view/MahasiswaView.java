package com.pbo.tubes.view;

import com.pbo.tubes.model.Menu;
import com.pbo.tubes.model.user.Mahasiswa;

import java.util.Scanner;

public class MahasiswaView {

    Scanner scannerNumber = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    public Menu mahasiswaMenu(Mahasiswa mahasiswa) {
        System.out.println("\n----------------------------------------------------");
        System.out.println("Selamat datang mahasiswa :");
        System.out.println("----------------------------------------------------");
        System.out.println("Nama : " + mahasiswa.getName());
        System.out.println("Email : " + mahasiswa.getEmail());
        System.out.println("----------------------------------------------------");

        System.out.println("Pilih menu :");
        System.out.println("1. " + Menu.ABSENSI.name());
        System.out.println("2. " + Menu.LIHAT_STATUS_ABSENSI.name());
        System.out.println("0. " + Menu.LOGOUT.name());

        int menu;

        do {
            System.out.print("Masukan menu : ");
            menu = scannerNumber.nextInt();

            if (menu > 2) {
                System.out.println("Menu tidak ditemukan!");
            } else {
                break;
            }
        } while (true);

        switch (menu) {
            case 1:
                return Menu.ABSENSI;
            case 2:
                return Menu.LIHAT_STATUS_ABSENSI;
            default:
                return Menu.LOGOUT;
        }
    }

    public void absensi() {
        String absen = "Saya mengikuti mata kuliah ini!";
        String requestAbsen;

        do {
            System.out.println("\n----------------------------------------------------");
            System.out.println("Masukan kata ini, untuk melakukan absensi : \n" + absen);
            System.out.println("----------------------------------------------------");

            System.out.print("Masukan kata : ");
            requestAbsen = scannerString.nextLine();
            if (!requestAbsen.equals(absen)) {
                System.out.println("Kata tidak sama, coba lagi!");
            } else {
                break;
            }
        } while (true);

        System.out.println("\nSelamat absensi berhasil!");

        System.out.print("Enter untuk Keluar..");
        scannerString.nextLine();
    }

    public void lihatStatusAbsensi(Mahasiswa mahasiswa) {
        System.out.println("\n----------------------------------------------------");
        if (mahasiswa.isAbsen()) {
            System.out.println("Kamu sudah melakukan absensi!");
        } else {
            System.out.println("Kamu belum melakukan absensi!");
        }
        System.out.println("----------------------------------------------------");

        System.out.print("Enter untuk Keluar..");
        scannerString.nextLine();
    }

    public boolean logoutView() {
        System.out.println("\n----------------------------------------------------");
        System.out.println("Apakah kamu yakin ingin logout");
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

        if ("1".equals(menu)) {
            System.out.print("Enter untuk Keluar..");
            scannerString.nextLine();
        }

        return "1".equals(menu);
    }
}
