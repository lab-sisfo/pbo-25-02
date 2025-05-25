package pbo25.week_7;

import java.util.Scanner;

public class LibraryCLI {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        library.addItem(new Book("Harry Potter", 1, "JK Rowling"));
        library.addItem(new DVD("Avengers", 2, 120));
        Member member = new Member("Naailah", 101);
        library.addMember(member);

        int pilihan;
        int itemId, days, returnId, daysLate, memberId, duration; // Deklarasi variabel di sini
        String title, author, name, jenis;

        do {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul item: ");
                    title = scanner.nextLine();
                    System.out.print("Masukkan ID item: ");
                    itemId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Jenis item (buku/DVD): ");
                    jenis = scanner.nextLine().toLowerCase();
                    if (jenis.equals("buku")) {
                        System.out.print("Masukkan nama pengarang: ");
                        author = scanner.nextLine();
                        library.addItem(new Book(title, itemId, author));
                        System.out.println("Buku berhasil ditambahkan.");
                    } else if (jenis.equals("dvd")) {
                        System.out.print("Masukkan durasi (menit): ");
                        duration = scanner.nextInt();
                        scanner.nextLine();
                        library.addItem(new DVD(title, itemId, duration));
                        System.out.println("DVD berhasil ditambahkan.");
                    } else {
                        System.out.println("Jenis item tidak valid.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan nama anggota: ");
                    name = scanner.nextLine();
                    System.out.print("Masukkan ID anggota: ");
                    memberId = scanner.nextInt();
                    scanner.nextLine();
                    library.addMember(new Member(name, memberId));
                    System.out.println("Anggota berhasil ditambahkan.");
                    break;

                case 3:
                    System.out.print("Masukkan ID item: ");
                    itemId = scanner.nextInt();
                    System.out.print("Masukkan lama pinjam (hari): ");
                    days = scanner.nextInt();
                    try {
                        LibraryItem item = library.findItemById(itemId);
                        String result = member.borrow(item, days);
                        System.out.println(result);
                        library.getLogger().logActivity(item.getTitle() + " dipinjam oleh " + member.getName());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID item yang dikembalikan: ");
                    returnId = scanner.nextInt();
                    System.out.print("Masukkan jumlah hari keterlambatan: ");
                    daysLate = scanner.nextInt();
                    try {
                        LibraryItem item = library.findItemById(returnId);
                        String result = member.returnItem(item, daysLate);
                        System.out.println(result);
                        library.getLogger().logActivity(item.getTitle() + " dikembalikan oleh " + member.getName());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("--- Status Perpustakaan ---");
                    System.out.println(library.getLibraryStatus());
                    break;

                case 6:
                    System.out.println("--- Log Aktivitas ---");
                    System.out.println(library.getAllLogs());
                    break;

                case 7:
                    System.out.println("--- Item yang Dipinjam Anggota ---");
                    member.getBorrowedItems();
                    break;

                case 8:
                    System.out.println("Keluar dari sistem. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 8);

        scanner.close();
    }
}