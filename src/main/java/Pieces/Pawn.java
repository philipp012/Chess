package Pieces;

import Enums.COLOR;

public class Pawn extends Piece {
    public Pawn(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }
}
