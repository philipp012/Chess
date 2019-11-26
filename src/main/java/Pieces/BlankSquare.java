package Pieces;

import Enums.COLOR;

public class BlankSquare extends Piece {
    public BlankSquare() {
        this.setSymbol("\u2001");
        this.setColor(COLOR.NONE);
    }
}
