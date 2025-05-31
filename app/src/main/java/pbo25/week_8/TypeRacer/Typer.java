package main.java.pbo25.week_8.TypeRacer;

class Typer extends Thread {
    private String botName, wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;
    private long startTime;
    private long endTime;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.wordsTyped = "";
        this.typeRacer = typeRacer;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setWpm(double wpm) {
        this.wpm = wpm;
    }

    public void addWordsTyped(String newWordsTyped) {
        this.wordsTyped += newWordsTyped + " ";
    }

    public String getWordsTyped() {
        return wordsTyped.trim();
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }

    public boolean isFinished() {
        return endTime > 0;
    }

    public int getTypingDuration() {
        return (int) ((endTime - startTime) / 1000);
    }

    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");

        // ✅ TODO (1) — hitung durasi per kata dalam ms
        long howLongToType = (long) ((60.0 / wpm) * 1000); // dalam milidetik

        // ✅ TODO (2) — ketik tiap kata berdasarkan jeda
        startTime = System.currentTimeMillis();

        for (String word : wordsToType) {
            try {
                Thread.sleep(howLongToType);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addWordsTyped(word);
        }

        endTime = System.currentTimeMillis();

        addWordsTyped("(Selesai)");

        // ✅ TODO (3) — tambahkan hasil ke klasemen
        typeRacer.addResult(this);
    }
}
