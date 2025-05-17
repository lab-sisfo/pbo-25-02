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
        return items.stream()
            .filter(item -> item.itemId == itemId)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan."));
    }

    public String getLibraryStatus() {
        StringBuilder status = new StringBuilder();
        for (LibraryItem item : items) {
            String kondisi = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            status.append(item.getDescription()).append(" - ").append(kondisi).append("\n");
        }
        return status.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Member findMemberById(int id) {
        return members.stream()
            .filter(m -> m.memberId == id)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Member tidak ditemukan."));
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}
