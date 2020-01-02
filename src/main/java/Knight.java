import Enums.COLOR;

import static java.lang.Math.abs;

public class Knight extends Piece {
    public Knight(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }

    @Override
    public Piece[][] move(int[][] move, Board board) {
        int xfrom = move[0][0];
        int yfrom = move[0][1];
        int xto = move[1][0];
        int yto = move[1][1];


        // check if move valid
        if (abs(xto - xfrom) == 2 && abs(yto - yfrom) == 1 || abs(xto - xfrom) == 1 && abs(yto - yfrom) == 2 ) {
            // execute move
            board.getBoard()[yto][xto] = this;
            board.getBoard()[yfrom][xfrom] = new BlankSquare();
        }

        return board.getBoard();
    }
}
