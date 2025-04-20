public class Pelindung {
    String badan;
    String kepala;

    public Pelindung(String badan, String kepala) {
        this.badan = badan;
        this.kepala = kepala;
    }

    public String getPelindung() {
        return "Atasan: " + (kepala.trim().isEmpty() ? "Tidak ada" : kepala) +
               ", Badan: " + (badan.trim().isEmpty() ? "Tidak ada" : badan);
    }

    public int getDef(int random) {
        if (random == 0) {
            if (badan.equalsIgnoreCase("Hoodie")) {
                return 4;
            } else if (badan.trim().isEmpty()) {
                return 0;
            } else {
                return 2;
            }
        } else {
            if (kepala.equalsIgnoreCase("Helm")) {
                return 5;
            } else if (kepala.trim().isEmpty()) {
                return 0;
            } else {
                return 3;
            }
        }
    }
}
