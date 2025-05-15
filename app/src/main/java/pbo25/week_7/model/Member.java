package pbo25.week_7.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        try {
            String result = item.borrowItem(days);
            borrowedItems.add(item); // Menambahkan item ke daftar yang dipinjam
            return result;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (borrowedItems.remove(item)) {
            item.setBorrowed(false);
            if (daysLate > 14) {
                return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda sebesar Rp"
                        + item.calculateFine(daysLate);
            } else {
                return "Item " + item.getTitle() + " berhasil dikembalikan.";
            }
        } else {
            return "Item " + item.getTitle() + " tidak ditemukan dalam daftar yang dipinjam.";
        }
    }

    public String getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            return "Tidak ada item yang dipinjam.";
        } else {
            StringBuilder list = new StringBuilder();
            list.append("+-----+-------------------+\n");
            list.append("| ID  |       Judul       |\n");
            list.append("+-----+-------------------+\n");

            for (LibraryItem item : borrowedItems) {
                list.append(String.format("| %-3d | %-17s |\n", item.getItemId(), item.getTitle()));
            }

            list.append("+-----+-------------------+\n");
            return list.toString();
        }
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<LibraryItem> getBorrowedItemsList() {
        return new ArrayList<>(borrowedItems);
    }
}