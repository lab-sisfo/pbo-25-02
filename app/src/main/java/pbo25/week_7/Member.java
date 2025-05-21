package pbo25.week_7;

import java.util.*;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) throw new IllegalStateException("Item tidak tersedia.");
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) return "Item tidak sedang dipinjam oleh member ini.";
        borrowedItems.remove(item);
        item.returnItem();
        double fine = item.calculateFine(daysLate);
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine);
    }

  public void getBorrowedItems() {
    if (borrowedItems.isEmpty()) {
        System.out.println("Tidak ada item yang dipinjam.");
    } else {
        System.out.println("+-----+---------+");
        System.out.println("| ID  | Judul   |");
        System.out.println("+-----+---------+");
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-3d | %-7s |\n", item.getItemId(), item.getTitle());
        }
        System.out.println("+-----+---------+");
    }
}


    public String getName() {
        return name;
    }

    public int getMemberId() {
    return memberId;
    }

}
