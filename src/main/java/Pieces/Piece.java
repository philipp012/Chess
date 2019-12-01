package Pieces;

import Enums.COLOR;

public abstract class Piece {
    private COLOR color;
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public void move(int[][] to) {

    }
}
