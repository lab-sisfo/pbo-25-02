package pbo25.week_7;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import pbo25.week_7.model.Library;
import pbo25.week_7.model.LibraryItem;
import pbo25.week_7.model.Member;
import pbo25.week_7.model.Book;
import pbo25.week_7.model.DVD;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item (a. Buku, b. DVD): ");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi (1-8): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Pilih jenis item (a. Buku, b. DVD): ");
                    String pilih = scanner.nextLine();
                    if (pilih.equals("a")) {
                        System.out.print("Masukkan judul buku: ");
                        String bookTitle = scanner.nextLine();
                        System.out.print("Masukkan nama pengarang: ");
                        String author = scanner.nextLine();
                        LibraryItem book = new Book(bookTitle, library.getNextItemId(), false, author);
                        System.out.println(library.addItem(book));
                    } else if (pilih.equals("b")) {
                        System.out.print("Masukkan judul DVD: ");
                        String dvdTitle = scanner.nextLine();
                        System.out.print("Masukkan durasi DVD (menit): ");
                        int duration = scanner.nextInt();
                        LibraryItem dvd = new DVD(dvdTitle, library.getNextItemId(), false, duration);
                        System.out.println(library.addItem(dvd));
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan nama anggota: ");
                    String memberName = scanner.nextLine();

                    int memberId = -1;
                    boolean idExists;

                    do {
                        idExists = false;
                        try {
                            System.out.print("Masukkan ID anggota: ");
                            memberId = scanner.nextInt();
                            scanner.nextLine();

                            // Cek apakah ID sudah ada
                            for (Member member : library.getMembers()) {
                                if (member.getMemberId() == memberId) {
                                    idExists = true;
                                    System.out.println("ID anggota sudah ada. Silakan masukkan ID yang lain.");
                                    break;
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("ID harus berupa angka. Silakan coba lagi.");
                            scanner.nextLine();
                        }
                    } while (idExists);

                    Member member = new Member(memberName, memberId);
                    library.addMember(member);
                    System.out.println("Anggota " + memberName + " berhasil ditambahkan.");
                    break;
                case 3:
                    System.out.print("Masukkan ID item yang ingin dipinjam: ");
                    int borrowId = scanner.nextInt();
                    System.out.print("Masukkan id anggota: ");
                    int borrowerId = scanner.nextInt();
                    try {
                        LibraryItem borrowedItem = library.findItemById(borrowId);
                        System.out.print("Masukkan durasi pinjam dalam hari: ");
                        int days = scanner.nextInt();
                        System.out.println(library.isborrowItem(borrowedItem, borrowerId, days));
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Masukkan ID item yang ingin dikembalikan: ");
                    int returnId = scanner.nextInt();
                    System.out.print("Masukkan jumlah hari terlambat: ");
                    int daysLate = scanner.nextInt();
                    try {
                        LibraryItem returnedItem = library.findItemById(returnId);
                        System.out.println(library.returnItem(returnedItem, daysLate));
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println(library.getLibraryStatus());
                    break;
                case 6:
                    System.out.println("Log Aktivitas:");
                    System.out.println(library.getAllLogs());
                    break;
                case 7:
                    System.out.print("Masukkan id anggota: ");
                    int memberToCheck = scanner.nextInt();
                    System.out.println(library.getBorrowedItemsForMember(memberToCheck));
                    break;
                case 8:
                    System.out.println("Keluar dari sistem.");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        } while (choice != 8);
        scanner.close();
    }
}