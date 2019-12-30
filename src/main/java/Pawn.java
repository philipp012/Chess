import Enums.COLOR;

import static java.lang.Math.abs;

public class Pawn extends Piece {
    public Pawn(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }

    @Override
    public Piece[][] move(int[][] move, Board board) {
        int xfrom = move[0][0];
        int yfrom = move[0][1];
        int xto = move[1][0];
        int yto = move[1][1];

        // check move validity
        if (abs(yto - yfrom) <= 2 && abs(xfrom - xto) <= 1) {
            // upwards
            if (yfrom < yto) {
                // 1 step forward
                if (yto - yfrom == 1 && board.getBoard()[xto][yto].getColor().equals(COLOR.NONE)) {
                    board.getBoard()[xto][yto] = this;
                    board.getBoard()[xfrom][yfrom] = new BlankSquare();
                    return board.getBoard();
                }
                // 2 steps forward
                if (this.getColor().equals(COLOR.WHITE) && yfrom == 1 && board.getBoard()[xto][yto - 1].getColor().equals(COLOR.NONE) && board.getBoard()[xto][yto].getColor().equals(COLOR.NONE)) {
                    board.getBoard()[xto][yto] = this;
                    board.getBoard()[xfrom][yfrom] = new BlankSquare();
                    return board.getBoard();
                }
            }
            // downwards
            else {
                // 1 step forward
                if (yto + yfrom == 1 && board.getBoard()[xto][yto].getColor().equals(COLOR.NONE)) {
                    board.getBoard()[xto][yto] = this;
                    board.getBoard()[xfrom][yfrom] = new BlankSquare();
                    return board.getBoard();
                }
                // 2 steps forward
                if (this.getColor().equals(COLOR.WHITE) && yfrom == 6 && board.getBoard()[xto][yto - 1].getColor().equals(COLOR.NONE) && board.getBoard()[xto][yto].getColor().equals(COLOR.NONE)) {
                    board.getBoard()[xto][yto] = this;
                    board.getBoard()[xfrom][yfrom] = new BlankSquare();
                    board.printBoard();
                    return board.getBoard();
                }
            }

            // beating
            if (!board.getBoard()[xto][yto].getColor().equals(this.getColor()) && board.getBoard()[xto][yto].getColor().equals(COLOR.NONE)) {
                board.getBoard()[xto][yto] = this;
                board.getBoard()[xfrom][yfrom] = new BlankSquare();
                return board.getBoard();
            }
        }
        return null;
    }
}
