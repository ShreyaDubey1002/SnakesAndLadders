package SnakesAndLadders;

public class Dice {
    Integer minValue;
    Integer maxValue;

    Dice() {
        this.minValue = 1;
        this.maxValue = 6;
    }

    Dice(Integer minValue, Integer maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    Integer getMinValue() {
        return this.minValue;
    }

    Integer getMaxValue() {
        return this.maxValue;
    }

    Integer rollDice() {
        Integer range = maxValue - minValue + 1;
        Integer diceValue = (int)(Math.random()*range) + minValue;
        return diceValue;
    }
}
