package pbo25.week_7.model;

public abstract class LibraryItem {
    private String title;
    private int itemId;
    private boolean isBorrowed;

    public LibraryItem(String title, int id, boolean borrowed) {
        this.title = title;
        this.itemId = id;
        this.isBorrowed = borrowed;
    }

    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    public String returnItem(int daysLate) {
        setBorrowed(false);
        double fine = calculateFine(daysLate);
        return this.title + " dikembalikan. Denda: " + fine;
    }

    public String getTitle() {
        return title;
    }

    public int getItemId() {
        return itemId;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
}