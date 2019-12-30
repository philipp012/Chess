import Enums.COLOR;

import static java.lang.Math.abs;

public class Bishop extends Piece {
    public Bishop(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }

    @Override
    public Piece[][] move(int[][] move, Board board) {
        int xfrom = move[0][0];
        int yfrom = move[0][1];
        int xto = move[1][0];
        int yto = move[1][1];

        // check if move is valid
        if (abs(xfrom - xto) == abs(yfrom - yto)) {
            // top left
            if (xto < xfrom && yto < yfrom) {
                int counter = yfrom - 1;
                while (counter > yto + 1) {
                    // check if lane is free
                    if (!board.getBoard()[xfrom - 1][counter].getColor().equals(COLOR.NONE)) {
                        return board.getBoard();
                    }
                    counter--;
                }
            }

            // top right
            else if (xto > xfrom && yto < yfrom) {
                int counter = yfrom - 1;
                while (counter > yto + 1) {
                    // check if lane is free
                    if (!board.getBoard()[xfrom + 1][counter].getColor().equals(COLOR.NONE)) {
                        return board.getBoard();
                    }
                    counter--;
                }

            }
            // bottom left
            else if (xto < xfrom && yto > yfrom) {
                int counter = yfrom + 1;
                while (counter < yto - 1) {
                    // check if lane is free
                    if (!board.getBoard()[xfrom - 1][counter].getColor().equals(COLOR.NONE)) {
                        return board.getBoard();
                    }
                    counter++;
                }
            }
            // bottom right
            else if (xto > xfrom && yto > yfrom) {
                int counter = yfrom + 1;
                while (counter < yto - 1) {
                    // check if lane is free
                    if (!board.getBoard()[xfrom + 1][counter].getColor().equals(COLOR.NONE)) {
                        return board.getBoard();
                    }
                    counter++;
                }
            }

            // execute move
            board.getBoard()[yto][xto] = this;
            board.getBoard()[yfrom][xfrom] = new BlankSquare();
        }
        return board.getBoard();
    }
}
