package pbo25.week_8.TypeRacer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

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

    // TODO (4)
    public synchronized void addResult(Result result) {
        rareStanding.add(result);
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        // TODO (5)
        rareStanding.sort(Comparator.comparingInt(Result::getFinishTime));
        int position = 1;
        for (Result r : rareStanding) {
            System.out.println(position + ". " + r.getName() + " = " + r.getFinishTime() + " detik");
            position++;
        }
    }

    public void startRace() {
        // TODO (6)
        for (Typer typer : rareContestant) {
            typer.start();
        }
    }

    public void displayRaceStandingPeriodically() throws InterruptedException {
        // TODO (7)
        while (rareStanding.size() < rareContestant.size()) {
            System.out.println("\nTyping Progress...");
            System.out.println("===================");
            for (Typer t : rareContestant) {
                System.out.println("-" + t.getBotName() + " => " + t.getWordsTyped());
            }
            Thread.sleep(2000);
        }

        // TODO (8)
        printRaceStanding();
    }
}

