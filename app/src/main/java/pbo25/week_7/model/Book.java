package pbo25.week_7.model;

public class Book extends LibraryItem {
    private String author;

    public Book(String title, int id, boolean borrowed, String author) {
        super(title, id, borrowed);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + getTitle() + " oleh " + this.author + ", ID: " + getItemId();
    }

    @Override
    public String borrowItem(int days) {
        if (days > 14) {
            throw new IllegalArgumentException("Maksimal peminjaman adalah 14 hari.");
        } else if (isBorrowed()) {
            throw new IllegalArgumentException(getTitle() + " telah dipinjam dan belum dikembalikan.");
        } else {
            setBorrowed(true);
            return getTitle() + " berhasil dipinjam untuk " + days + " hari.";
        }
    }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate > 0) {
            return daysLate * 10000;
        }
        return 0.0;
    }
}