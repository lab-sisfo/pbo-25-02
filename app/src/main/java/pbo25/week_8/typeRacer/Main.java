package pbo25.week_8.typeRacer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TypeRacer typeRacer = new TypeRacer();
        typeRacer.setNewWordsToType();
        System.out.println("|| Text to Type ||");
        System.out.println("\"" + typeRacer.getWordsToType() + "\"");

        Typer[] typers = new Typer[3];

        typers[0] = new Typer("Bot Sisfo_1", 80, typeRacer);
        typers[1] = new Typer("Bot Sisfo_2", 72, typeRacer);
        typers[2] = new Typer("Bot Sisfo_3", 70, typeRacer);

        typeRacer.getRareContestant().addAll(Arrays.asList(typers));

        typeRacer.startRace();
        typeRacer.displayRaceStandingPeriodically();
    }
}