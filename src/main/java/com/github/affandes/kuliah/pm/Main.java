package com.github.affandes.kuliah.pm;


import java.util.Stack;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Stack<String> history = new Stack<>();
        Scanner input = new Scanner(System.in);
        
        history.push("google.com");
        history.push("uin-suska.ac.id");

        System.out.println("(Simulasi: 2 data history telah ditambahkan)");
        while (true) {
            System.out.println("\n===== Menu Browser =====");
            System.out.println("1. Browse");
            System.out.println("2. Back");
            System.out.println("3. View History");
            System.out.println("4. Exit");
            System.out.print("Masukkan pilihan Anda (1-4): ");

            int pilihan;

            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                continue;
            }
            if (pilihan == 1) {
                System.out.print("Masukkan nama website baru: ");
                String websiteBaru = input.nextLine();
                history.push(websiteBaru);
                System.out.println("Berhasil mengunjungi: " + websiteBaru);

            } else if (pilihan == 2) {
                if (history.isEmpty()) {
                    System.out.println("History kosong, tidak dapat kembali.");
                } else {
                    String websiteDihapus = history.pop();
                    System.out.println("Kembali dari: " + websiteDihapus);

                    if (!history.isEmpty()) {
                        System.out.println("Sekarang berada di: " + history.peek());
                    } else {
                        System.out.println("History saat ini kosong.");
                    }
                }
            } else if (pilihan == 3) {
                System.out.println("\n--- Riwayat Browser (Terbaru) ---");

                if (history.isEmpty()) {
                    System.out.println("(Riwayat kosong)");
                } else {
                    for (int i = history.size() - 1; i >= 0; i--) {
                        System.out.println(history.get(i));
                    }
                }

            } else if (pilihan == 4) {
                System.out.println("Program dihentikan.");
                break;

            } else {
                System.out.println("Pilihan tidak valid. Harap masukkan angka 1-4.");
            }
        }
        input.close();
    }
}
