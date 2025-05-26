package main.java.pbo25.week_8.TypeRacer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> rareContestant = new ArrayList<>();
    private ArrayList<Result> rareStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRareContestant() {
        return rareContestant;
    }

    private String[] wordsToTypeList = {
            "Di Bikini Bottom ada Spongebob Squarepants, dia memang keren suka main drumband",
            "Dia jadi koki masaknya krabby patty, menjalani hari hidup bersama Garry",
            "Ayo sama-sama sebutkan nama-nama makhluk dalam sana di Bikini Bottom jaya",
            "Namun ada juga namanya Patrick Star, walau dia cetar tapi hidupnya liar",
            "Tinggal dalam batu tapi suka membantu, sayang hanya satu otaknya itu buntu"
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // ✅ TODO (4)
    public synchronized void addResult(Typer typer) {
        rareStanding.add(new Result(typer.getName(), typer.getTypingDuration()));
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        // ✅ TODO (5)
        // Urutkan berdasarkan waktu tercepat
        Collections.sort(rareStanding, Comparator.comparingInt(Result::getTypingDuration));

        int position = 1;
        for (Result result : rareStanding) {
            System.out.println(position + ". " + result.getName() + " = " + result.getTypingDuration() + " detik");
            position++;
        }
    }

    // ✅ TODO (6)
    public void startRace() {
        for (Typer typer : rareContestant) {
            typer.setWordsToType(wordsToType);
            typer.setRace(this); // supaya bisa panggil addResult saat selesai
            typer.start();
        }
    }

    // ✅ TODO (7) & (8)
    public void displayRaceStandingPeriodically() throws InterruptedException {
        boolean allFinished = false;

        while (!allFinished) {
            Thread.sleep(2000);
            System.out.println("\nTyping Progress ...");
            System.out.println("===================");

            for (Typer typer : rareContestant) {
                System.out.println(typer.getName() + " => " + typer.getTypedText());
            }

            allFinished = true;
            for (Typer typer : rareContestant) {
                if (!typer.isFinished()) {
                    allFinished = false;
                    break;
                }
            }
        }

        // ✅ Setelah semua selesai
        printRaceStanding();
    }
}
