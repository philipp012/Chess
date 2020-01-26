import Enums.COLOR;

import static java.lang.Math.abs;
import static java.lang.Math.toRadians;

public class Bishop extends Piece {
    public Bishop(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }

    @Override
    public boolean checkMove(int[][] move, Board board) {
        int xfrom = move[0][0];
        int yfrom = move[0][1];
        int xto = move[1][0];
        int yto = move[1][1];

        // check if move is valid
        if (abs(xfrom - xto) == abs(yfrom - yto)) {
            // top left
            if (xto < xfrom && yto < yfrom) {
                int xchecker = xfrom - 1;
                for (int i = yfrom - 1; i > yto; i--) {
                    // check if lane is free
                    if (!board.getBoard()[i][xchecker].getColor().equals(COLOR.NONE)) {
                        return false;
                    }
                    xchecker--;
                }
            }
            // top right
            if (xto > xfrom && yto < yfrom) {
                int xchecker = xfrom + 1;
                for (int i = yfrom - 1; i > yto; i--) {
                    // check if lane is free
                    if (!board.getBoard()[i][xchecker].getColor().equals(COLOR.NONE)) {
                        return false;
                    }
                    xchecker++;
                }
            }

            // bottom left
            if (xto < xfrom && yto > yfrom) {
                int xchecker = xfrom - 1;
                for (int i = yfrom + 1; i < yto; i++) {
                    // check if lane is free
                    if (!board.getBoard()[i][xchecker].getColor().equals(COLOR.NONE)) {
                        return false;
                    }
                    xchecker--;
                }
            }

            // bottom right
            if (xto > xfrom && yto > yfrom) {
                int xchecker = xfrom + 1;
                for (int i = yfrom + 1; i < yto; i++) {
                    // check if lane is free
                    if (!board.getBoard()[i][xchecker].getColor().equals(COLOR.NONE)) {
                        return false;
                    }
                    xchecker++;
                }
            }


            // execute move
            return true;
        }
        return false;
    }
}
