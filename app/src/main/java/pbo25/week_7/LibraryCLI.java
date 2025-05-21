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
        do {
            System.out.println("\n=== Sistem Perpustakaan ===");
            System.out.println("1. Pinjam item");
            System.out.println("2. Kembalikan item");
            System.out.println("3. Lihat status perpustakaan");
            System.out.println("4. Lihat log aktivitas");
            System.out.println("5. Lihat item yang dipinjam");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID item: ");
                    int itemId = scanner.nextInt();
                    System.out.print("Masukkan lama pinjam (hari): ");
                    int days = scanner.nextInt();
                    try {
                        LibraryItem item = library.findItemById(itemId);
                        String result = member.borrow(item, days);
                        System.out.println(result);
                        library.getLogger().logActivity(item.getTitle() + " dipinjam oleh " + member.getName());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Masukkan ID item yang dikembalikan: ");
                    int returnId = scanner.nextInt();
                    System.out.print("Masukkan jumlah hari keterlambatan: ");
                    int daysLate = scanner.nextInt();
                    try {
                        LibraryItem item = library.findItemById(returnId);
                        String result = member.returnItem(item, daysLate);
                        System.out.println(result);
                        library.getLogger().logActivity(item.getTitle() + " dikembalikan oleh " + member.getName());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("--- Status Perpustakaan ---");
                    System.out.println(library.getLibraryStatus());
                    break;

                case 4:
                    System.out.println("--- Log Aktivitas ---");
                    System.out.println(library.getAllLogs());
                    break;

                case 5:
                    System.out.println("--- Item yang Dipinjam ---");
                    member.getBorrowedItems();
                    break;

                case 0:
                    System.out.println("Keluar dari sistem. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);

        scanner.close();
    }
}
