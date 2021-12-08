package SnakesAndLadders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Board {
    Integer size;
    Integer start;
    Integer end;
    HashMap<Integer, Integer> snakes;
    HashMap<Integer, Integer> ladders;

    Board() {
        this.size = 100;
        this.start = 0;
        this.end = this.start+this.size;
        this.snakes = new HashMap<Integer, Integer>();
        this.ladders = new HashMap<Integer, Integer>();
    }

    Board(int size) {
        this.size = size;
        this.start = 0;
        this.end = this.start+this.size;
        this.snakes = new HashMap<Integer, Integer>();
        this.ladders = new HashMap<Integer, Integer>();
    }

    int getSize() {
        return this.size;
    }

    int getStart() {
        return this.start;
    }

    int getEnd() {
        return this.end;
    }

    int isSnake (int pos) {
        if (snakes.containsKey(pos))
            return snakes.get(pos);
        return -1;
    }

    int isLadder (int pos) {
        if (ladders.containsKey(pos))
            return ladders.get(pos);
        return -1;
    }

    void addSnakesList(ArrayList<Integer> snakeHeads, ArrayList<Integer> snakeTails) {
        Iterator<Integer> headsIter = snakeHeads.iterator();
        Iterator<Integer> tailsIter = snakeTails.iterator();
        while (headsIter.hasNext() && tailsIter.hasNext()) {
            addSnake(headsIter.next(), tailsIter.next());
        }
    }

    void addSnake(Integer snakeHead, Integer snakeTail) {
        snakes.put(snakeHead, snakeTail);
    }

    void addLaddersList(ArrayList<Integer> ladderStart, ArrayList<Integer> ladderEnd) {
        Iterator<Integer> startIter = ladderStart.iterator();
        Iterator<Integer> endIter = ladderEnd.iterator();
        while (startIter.hasNext() && endIter.hasNext()) {
            addLadder(startIter.next(), endIter.next());
        }
    }

    void addLadder(Integer ladderStart, Integer ladderEnd) {
        ladders.put(ladderStart, ladderEnd);
    }
}
