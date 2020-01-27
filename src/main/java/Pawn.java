import Enums.COLOR;

import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Pawn extends Piece {
    public Pawn(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }

    @Override
    public boolean checkMove(int[][] move, Board board, List<int[][]> moveTracker) {
        int xfrom = move[0][0];
        int yfrom = move[0][1];
        int xto = move[1][0];
        int yto = move[1][1];

        // check move validity
        if (abs(yto - yfrom) <= 2 && abs(xfrom - xto) <= 1) {
            // upwards
            if (yfrom > yto && this.getColor().equals(COLOR.WHITE)) {
                // 1 step forward
                if (yfrom - yto == 1 && board.getBoard()[yto][xto].getColor().equals(COLOR.NONE)) {
                    return true;
                }
                // 2 steps forward
                if (this.getColor().equals(COLOR.WHITE) && yfrom == 6 && board.getBoard()[yto + 1][xto].getColor().equals(COLOR.NONE) && board.getBoard()[yto][xto].getColor().equals(COLOR.NONE)) {
                    return true;
                }
            }
            // downwards
            else if (yto > yfrom && this.getColor().equals(COLOR.BLACK)){
                // 1 step forward
                if (yto - yfrom == 1 && board.getBoard()[yto][xto].getColor().equals(COLOR.NONE)) {
                    return true;
                }
                // 2 steps forward
                if (yfrom == 1 && board.getBoard()[yto -1][xto].getColor().equals(COLOR.NONE) && board.getBoard()[yto][xto].getColor().equals(COLOR.NONE)) {
                    return true;
                }
            }

            // beating
            if (!board.getBoard()[yto][xto].getColor().equals(this.getColor()) && !board.getBoard()[yto][xto].getColor().equals(COLOR.NONE)) {
                return true;
            }

            int[][] lastMove = moveTracker.get(moveTracker.size()-1);
            // en passant upwards
            if (lastMove[1][0] == yto -1 && abs(lastMove[0][0] - lastMove[1][0]) == 2 && board.getBoard()[yto-1][xto].getSymbol().equals("\u2659") || board.getBoard()[yto-1][xto].getSymbol().equals("\u265F") && board.getBoard()[yto-1][xto].getColor() != this.getColor()) {
                return true;
            }


        }
        // error
        return false;
    }
}
