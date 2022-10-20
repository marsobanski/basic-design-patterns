package co.devfoundry.singleton.homework;

import java.util.Random;
import java.util.Scanner;

public class GameEngine {

    private static GameEngine instance;
    private int score = 0;
    private int roundNum = 1;
    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    public void play() {
        while (roundNum <= 10) {
            System.out.print("Runda " + roundNum + ", Podaj liczbę: ");
            int randomNumber = random.nextInt(9) + 1;
            int userNumber = input.nextInt();
            input.reset();
            if (userNumber == randomNumber) {
                System.out.println("Brawo, zgadłeś cyfrę " + randomNumber);
                score++;
            } else {
                System.out.println("Niestety, twoja cyfra: " + userNumber + ", a poprawna: " + randomNumber);
            }
            roundNum++;
            System.out.println("Masz " + getScore() + " punktów");
            System.out.println("------------------------------");
        }
        System.out.println("Twoje punkty na koniec: " + getScore());
    }

    private int getScore() {
        return score;
    }
}
