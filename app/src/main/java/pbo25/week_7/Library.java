package pbo25.week_7;

import java.util.*;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) return item;
        }
        throw new NoSuchElementException("Item tidak ditemukan.");
    }
    public String getLibraryStatus() {
    StringBuilder status = new StringBuilder();
    status.append("+-----+---------+----------+\n");
    status.append("| ID  | Judul   | Status   |\n");
    status.append("+-----+---------+----------+\n");
    for (LibraryItem item : items) {
        String kondisi = item.isBorrowed() ? "Dipinjam" : "Tersedia";
        status.append(String.format("| %-3d | %-7s | %-8s |\n", item.getItemId(), item.getTitle(), kondisi));
    }
    status.append("+-----+---------+----------+");
    return status.toString();
}

    public String getAllLogs() {
        return logger.getLogs();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getMemberId() == id) {
                return m;
            }
        }
    throw new NoSuchElementException("Member tidak ditemukan.");
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}
