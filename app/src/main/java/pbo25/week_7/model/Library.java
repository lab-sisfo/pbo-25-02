package pbo25.week_7.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;
    private int nextItemId; // For item ID generation

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
        this.nextItemId = 1; // Initialize item ID
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        logger.logActivity("Item ditambahkan: " + item.getTitle());
        return item.getTitle() + " berhasil ditambahkan.";
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream()
                .filter(item -> item.getItemId() == itemId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan."));
    }

    public String getLibraryStatus() {
        StringBuilder status = new StringBuilder();
        status.append("+----------+----------------+-------------+\n");
        status.append("| ID Item  |      Judul     |   Status    |\n");
        status.append("+----------+----------------+-------------+\n");

        for (LibraryItem item : items) {
            status.append(String.format("| %-8d | %-14s | %-11s |\n",
                    item.getItemId(),
                    item.getTitle(),
                    item.isBorrowed() ? "Dipinjam" : "Tersedia"));
        }
        
        status.append("+----------+----------------+-------------+\n");
        return status.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public int getNextItemId() {
        return nextItemId++;
    }

    public void addMember(Member member) {
        members.add(member);
        logger.logActivity("Anggota ditambahkan: " + member.getName());
    }

    public String getBorrowedItemsForMember(int memberId) {
    for (Member member : members) {
        if (member.getMemberId() == memberId) {
            return member.getBorrowedItems();
        }
    }
    return "Member tidak ditemukan.";
}

    public String isborrowItem(LibraryItem item, int memberId, int days) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                try {
                    logger.logActivity("Item dipinjam: " + item.getTitle() + " oleh " + memberId);
                    return member.borrow(item, days);
                } catch (IllegalArgumentException e) {
                    return e.getMessage();
                }
            }
        }
        return "Member tidak ditemukan.";
    }

    public String returnItem(LibraryItem item, int daysLate) {
        for (Member member : members) {
            if (member.getBorrowedItemsList().contains(item)) {
                logger.logActivity("Item dikembalikan: " + item.getTitle() + " oleh " + member.getName());

                String returnMessage = member.returnItem(item, daysLate);
                item.setBorrowed(false);
                return returnMessage;
            }
        }
        return "Item tidak ditemukan dalam daftar anggota.";
    }

    public List<Member> getMembers() {
        return members;
    }
}