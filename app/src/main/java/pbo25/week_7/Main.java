import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = Integer.parseInt(scanner.nextLine());
            try {
                if (choice == 1) {
                    System.out.print("Masukkan jenis (book/dvd): ");
                    String type = scanner.nextLine();
                    System.out.print("Judul: ");
                    String title = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    if (type.equalsIgnoreCase("book")) {
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        library.addItem(new Book(title, id, author));
                    } else {
                        System.out.print("Durasi (menit): ");
                        int durasi = Integer.parseInt(scanner.nextLine());
                        library.addItem(new DVD(title, id, durasi));
                    }
                    System.out.println("Item berhasil ditambahkan.");
                } else if (choice == 2) {
                    System.out.print("Nama Anggota: ");
                    String name = scanner.nextLine();
                    System.out.print("ID Anggota: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    library.addMember(new Member(name, id));
                } else if (choice == 3) {
                    System.out.print("Nama Anggota: ");
                    String name = scanner.nextLine();
                    System.out.print("ID Item: ");
                    int itemId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Lama pinjam (hari): ");
                    int days = Integer.parseInt(scanner.nextLine());

                    Member member = library.findMemberByName(name);
                    LibraryItem item = library.findItemById(itemId);
                    String result = member.borrow(item, days);
                    System.out.println(result);
                    library.getLogger().logActivity(name + " meminjam item: " + item.getTitle() + " (ID: " + itemId + ")");
                } else if (choice == 4) {
                    System.out.print("Nama Anggota: ");
                    String name = scanner.nextLine();
                    System.out.print("ID Item: ");
                    int itemId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Hari keterlambatan: ");
                    int late = Integer.parseInt(scanner.nextLine());

                    Member member = library.findMemberByName(name);
                    LibraryItem item = library.findItemById(itemId);
                    String result = member.returnItem(item, late);
                    System.out.println(result);
                    library.getLogger().logActivity(name + " mengembalikan item: " + item.getTitle() + " (ID: " + itemId + ")");
                } else if (choice == 5) {
                    System.out.println(library.getLibraryStatus());
                } else if (choice == 6) {
                    System.out.println(library.getAllLogs());
                } else if (choice == 7) {
                    System.out.print("Nama Anggota: ");
                    String name = scanner.nextLine();
                    Member member = library.findMemberByName(name);
                    System.out.println(member.getBorrowedItems());
                } else if (choice == 8) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
        scanner.close();
    }
}