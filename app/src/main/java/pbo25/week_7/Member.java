import java.util.*;

public class Member {
    private String name;
    // private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        // this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) throw new IllegalStateException("Item tidak tersedia.");
        String msg = item.borrowItem(days);
        borrowedItems.add(item);
        return msg;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) return "Item tidak sedang dipinjam.";
        borrowedItems.remove(item);
        item.returnItem();
        double fine = item.calculateFine(daysLate);
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine);
    }

    public String getBorrowedItems() {
        if (borrowedItems.isEmpty()) return "Tidak ada item yang dipinjam";
        StringBuilder sb = new StringBuilder();
        for (LibraryItem item : borrowedItems) {
            sb.append(item.getDescription()).append("\n");
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }
}