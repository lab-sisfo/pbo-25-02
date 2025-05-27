package pbo25.week_8.typeRacer;

import java.util.ArrayList;
import java.util.Random;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> rareContestant = new ArrayList<>(); // kontestan
    private ArrayList<Result> rareStanding = new ArrayList<>(); // hasil balapan
    private long raceStartTime;

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRareContestant() {
        return rareContestant;
    }

    // Bisa diganti sesuai keinginan masing-masing
    private String[] wordsToTypeList = {
            "Di dunia sistem informasi ada Java, dia memang keren suka bikin aplikasi",
            "Dia jadi backend developer, menjalani hari hidup bersama database",
            "Ayo sama-sama sebutkan nama-nama bahasa pemrograman di dunia teknologi",
            "Namun ada juga namanya Python, walau dia cepat tapi kadang bikin error",
            "Tinggal di cloud tapi suka membantu, sayang kadang dia bikin kita bingung"
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // TODO (4)
    // Buat method addResult yang mana digunakan untuk menambahkan typer yang
    // telah selesai (mengetik semua kata), ke dalam list race standing.
    public synchronized void addFinishedTyper(Typer typer) {
        long finishTime = System.currentTimeMillis() - raceStartTime;
        double finishTimeInSeconds = finishTime / 1000.0;

        // Menggunakan constructor Result yang sesuai dengan kelas Result yang ada
        Result result = new Result(typer.getBotName(), (int) finishTimeInSeconds);
        rareStanding.add(result);
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================");

        // TODO (5)
        // Tampilkan klasemen akhir dari kompetisi, dengan format
        // {posisi}. {nama} = {waktu penyelesaian dalam detik} detik
        for (int i = 0; i < rareStanding.size(); i++) {
            Result result = rareStanding.get(i);
            System.out.println((i + 1) + ". " + result.getName() +
                    " = " + result.getFinishTime() + " detik");
        }
    }

    public void startRace() {
        // TODO (6)
        // Jalankan kompetisi untuk tiap kontestan
        raceStartTime = System.currentTimeMillis();
        // Start semua typer thread
        for (Typer typer : rareContestant) {
            typer.start();
        }
    }

    // TODO (7)
    // selama semua peserta belum selesai maka tampilkan typing progress-nya setiap
    // 2 detik, dengan format:
    // Typing Progress ...
    // ===================
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    public void displayRaceStandingPeriodically() throws InterruptedException {
        while (rareStanding.size() < rareContestant.size()) {
            System.out.println("Typing Progress ...");
            System.out.println("===================");

            for (Typer typer : rareContestant) {
                System.out.println(typer.getBotName() + " => " + typer.getWordsTyped());
            }
            System.out.println();

            Thread.sleep(2000); // Tunggu 2 detik
        }

        // TODO (8) - COMPLETED
        // Setelah semua typer selesai, tampilkan race standing setelah semua typer
        // selesai

        // Tunggu semua thread selesai
        for (Typer typer : rareContestant) {
            typer.join();
        }

        // Tampilkan progress terakhir
        System.out.println("Final Typing Progress:");
        System.out.println("===================");
        for (Typer typer : rareContestant) {
            System.out.println(typer.getBotName() + " => " + typer.getWordsTyped());
        }

        // Tampilkan klasemen akhir
        printRaceStanding();
    }

    // Method helper untuk menambahkan kontestan
    public void addContestant(Typer typer) {
        rareContestant.add(typer);
    }

    // Method helper untuk mengecek apakah semua typer sudah selesai
    public boolean isRaceFinished() {
        return rareStanding.size() >= rareContestant.size();
    }
}