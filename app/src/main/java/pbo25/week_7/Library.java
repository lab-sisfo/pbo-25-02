import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

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

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        for (LibraryItem item : items) {
            sb.append(item.getDescription())
              .append(" - ")
              .append(item.isBorrowed() ? "Dipinjam" : "Tersedia")
              .append("\n");
        }
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}
