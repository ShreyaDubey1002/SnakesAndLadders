package SnakesAndLadders;

import java.util.ArrayList;
import java.util.Iterator;

public class Game {

    Integer numberOfPlayers;
    ArrayList<Player> players;
    Board board;
    Dice dice;

    Game(Integer size, Integer numberOfPlayers,
         ArrayList<Integer> snakeHeads, ArrayList<Integer> snakeTails,
         ArrayList<Integer> ladderStart, ArrayList<Integer> ladderEnd,
         int diceMinValue, int diceMaxValue) {
        board = new Board(size);
        this.numberOfPlayers = numberOfPlayers;
        //ArrayList<Player> players = new ArrayList<Player>(numberOfPlayers);
        this.players = new ArrayList<Player>();
        for (int i=0;i<numberOfPlayers;i++) {
            players.add(new Player("Player" + i));
        }
        board.addSnakesList(snakeHeads, snakeTails);
        board.addLaddersList(ladderStart, ladderEnd);
        dice = new Dice(diceMinValue, diceMaxValue);
    }

    void start() {
        Integer count = 0;
        System.out.println("End : " + board.getEnd());

        while (count != numberOfPlayers) {
            for (int player = 0; player < numberOfPlayers && count != numberOfPlayers; player++) {
                Player curPlayer = players.get(player);
                if (curPlayer.isWinner())
                    continue;

                Integer nextValue = dice.rollDice();
                Integer nextPos = curPlayer.getPosition() + nextValue;

                if (nextPos > board.getEnd()) {
                    continue;
                }
                nextPos = checkForSnakesAndLadders(nextPos);
                // System.out.println("Dice roll : " + nextValue);
                // System.out.println("Current position : " + curPlayer.getPosition());
                curPlayer.setPosition(nextPos);
                System.out.println("Player : " + curPlayer.getName() + " is on position : " + curPlayer.getPosition());
                if (nextPos == board.getEnd()) {
                    curPlayer.setWinner(true);
                    count++;
                }
            }
        }
        Iterator<Player> iter = players.iterator();
        while (iter.hasNext()) {
            Player player = iter.next();
            if (player.isWinner()) {
                System.out.println("Player : " + player.getName() + " won in " + player.getSteps());
            } else {
                System.out.println("Player : " + player.getName() + " lost in " + player.getSteps());
            }
        }
    }

    Integer checkForSnakesAndLadders (Integer pos) {
        while (board.isSnake(pos) != -1 || board.isLadder(pos) != -1) {
            int snakePos = board.isSnake(pos);
            int ladderPos = board.isLadder(pos);
            if (snakePos != -1)
                pos = snakePos;
            else
                pos = ladderPos;
        }
        return pos;
    }
}
