package pbo25.week_8.TypeRacer;

class Typer extends Thread {
    private String botName, wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;

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
        return wordsTyped;
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }

    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");

        // TODO (1) => Hitung berapa detik delay per kata
        int howLongToType = (int) Math.round(60.0 / wpm);

        // TODO (2) => Loop setiap kata dan tambahkan ke wordsTyped
        long startTime = System.currentTimeMillis();
        for (String word : wordsToType) {
            try {
                Thread.sleep(howLongToType * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.addWordsTyped(word);
        }

        this.addWordsTyped("(Selesai)");

        // TODO (3) => Simpan waktu selesai dan masukkan ke klasemen
        int finishTime = (int) ((System.currentTimeMillis() - startTime) / 1000);
        typeRacer.addResult(new Result(botName, finishTime));
    }
}
