import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    List<LibraryItem> items;
    List<Member> members;
    LibraryLogger logger;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream()
                .filter(item -> item.getItemId() == itemId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan."));
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryLogger getLogger() {
        return logger;
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("+---------+--------------------+-----------+\n");
        sb.append("| ID Item | Judul              | Status    |\n");
        sb.append("+---------+--------------------+-----------+\n");
        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-7d | %-18s | %-9s |\n", item.getItemId(), item.getTitle(), status));
        }
        sb.append("+---------+--------------------+-----------+");
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }
}