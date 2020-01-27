import Enums.COLOR;

import java.util.List;

import static java.lang.Math.abs;

public class King extends Piece {
    public King(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }

    @Override
    public boolean checkMove(int[][] move, Board board, List<int[][]> moveTracker) {
        int xfrom = move[0][0];
        int yfrom = move[0][1];
        int xto = move[1][0];
        int yto = move[1][1];

        // check validity
        if (abs(xfrom - xto) == 1 && abs(yfrom - yto) == 1 || abs(xfrom - xto) == 0 && abs(yfrom - yto) == 1 || abs(xfrom - xto) == 1 && abs(yfrom - yto) == 0) {
            return true;
        }

        // castling kingside
        if (abs(xfrom - xto) == 2 && yfrom == yto && xfrom < xto && board.getBoard()[yfrom][xfrom+1].getColor().equals(COLOR.NONE)) {
            return true;
        }

        return false;
    }
}
