package SnakesAndLadders;

public class Player {
    String name;
    Integer position;
    Boolean winner;
    int steps;

    Player (String name) {
        this.name = name;
        this.position = 0;
        this.winner = false;
        this.steps = 0;
    }

    Integer getSteps() {
        return this.steps;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    Integer getPosition() {
        return position;
    }

    void setPosition(Integer position) {
        this.position = position;
        this.steps++;
    }

    Boolean isWinner() {
        return winner;
    }

    void setWinner(Boolean winner) {
        this.winner = winner;
    }
}
