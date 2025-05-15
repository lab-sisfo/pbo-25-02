package pbo25.week_7.model;

public class DVD extends LibraryItem {
    private int duration;

    public DVD(String title, int id, boolean isBorrowed, int duration) {
        super(title, id, isBorrowed);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD: " + getTitle() + ", durasi " + this.duration + " menit, ID: " + getItemId(); 
    }

    @Override
    public String borrowItem(int days) {
        if (days > 7) {
            throw new IllegalArgumentException("DVD tidak dapat dipinjam lebih dari 7 hari.");
        } else {
            setBorrowed(true);
            return "Item " + getTitle() + " berhasil dipinjam selama " + days + " hari.";
        }
    }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate > 0) {
            return daysLate * 25000;
        }
        return 0;
    }
}