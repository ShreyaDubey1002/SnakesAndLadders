package SnakesAndLadders;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    public static void main (String[] args) {
        System.out.println("Enter size of board ");
        Scanner sc = new Scanner(System.in);
        Integer size = sc.nextInt();

        System.out.println("Enter number of players.");
        int numberOfPlayers = sc.nextInt();

        ArrayList<Integer> snakeHeads = new ArrayList<Integer> (Arrays.asList(47, 34, 25, 18, 12));
        ArrayList<Integer> snakeTails = new ArrayList<Integer> (Arrays.asList(20, 24, 17,  8, 5));
        ArrayList<Integer> ladderStart = new ArrayList<Integer> (Arrays.asList(4, 15, 22, 30, 38));
        ArrayList<Integer> ladderEnd = new ArrayList<Integer> (Arrays.asList(14, 36, 42, 35, 42));

        Game game = new Game(size, numberOfPlayers, snakeHeads, snakeTails, ladderStart, ladderEnd, 1, 6);
        game.start();
    }
}
