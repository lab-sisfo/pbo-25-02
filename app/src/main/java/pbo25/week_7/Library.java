import java.util.*;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream().filter(i -> i.getItemId() == itemId).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan."));
    }

    public Member findMemberByName(String name) {
        return members.stream().filter(m -> m.getName().equalsIgnoreCase(name)).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Member tidak ditemukan."));
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder("| ID | Judul | Status |\n");
        sb.append("+-----+--------+-----------+\n");
        for (LibraryItem item : items) {
            sb.append(String.format("| %d | %s | %s |\n",
                    item.getItemId(), item.getTitle(), item.isBorrowed() ? "Dipinjam" : "Tersedia"));
        }
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}