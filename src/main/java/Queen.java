import Enums.COLOR;

import static java.lang.Math.abs;

public class Queen extends Piece {
    public Queen(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }

    @Override
    public Piece[][] move(int[][] move, Board board) {
        int xfrom = move[0][0];
        int yfrom = move[0][1];
        int xto = move[1][0];
        int yto = move[1][1];

        // straight
        if (xfrom == xto || yfrom == yto) {
            // vertical
            if (xfrom == xto && yfrom != yto) {
                int counter = yfrom;
                // up
                if (yfrom > yto) {
                    counter--;
                    while (counter > yto + 1) {
                        // check if field is free
                        if (!board.getBoard()[counter][xfrom].getColor().equals(COLOR.NONE)) {
                            return null;
                        }
                        counter--;
                    }
                }
                // down
                else {
                    counter++;
                    while (counter < yto - 1) {
                        // check if field is free
                        if (!board.getBoard()[counter][xfrom].getColor().equals(COLOR.NONE)) {
                            return null;
                        }
                        counter++;
                    }
                }
            }
            // horizontal
            else if (xfrom != xto) {
                int counter = xfrom;
                //right
                if (xfrom < xto) {
                    counter++;
                    while (counter < xto - 1) {
                        // check if field is free
                        if (!board.getBoard()[yfrom][counter].getColor().equals(COLOR.NONE)) {
                            return null;
                        }
                        counter++;
                    }
                }
                // left
                else {
                    counter--;
                    while (counter > xto + 1) {
                        // check if field is free
                        if (!board.getBoard()[yfrom][counter].getColor().equals(COLOR.NONE)) {
                            return null;
                        }
                        counter--;
                    }
                }
            }
        }
        // diagonal
        else if (abs(xfrom - xto) == abs(yfrom - yto)) {
            // top left
            if (xto < xfrom && yto < yfrom) {
                int counter = yfrom - 1;
                while (counter > yto + 1) {
                    // check if lane is free
                    if (!board.getBoard()[xfrom - 1][counter].getColor().equals(COLOR.NONE)) {
                        return null;
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
                        return null;
                    }
                    counter--;
                }

            }
            // bottom left
            else if (xto < xfrom) {
                int counter = yfrom + 1;
                while (counter < yto - 1) {
                    // check if lane is free
                    if (!board.getBoard()[xfrom - 1][counter].getColor().equals(COLOR.NONE)) {
                        return null;
                    }
                    counter++;
                }
            }
            // bottom right
            else {
                int counter = yfrom + 1;
                while (counter < yto - 1) {
                    // check if lane is free
                    if (!board.getBoard()[xfrom + 1][counter].getColor().equals(COLOR.NONE)) {
                        return null;
                    }
                    counter++;
                }
            }
        }
        // execute move
        board.getBoard()[yto][xto] = this;
        board.getBoard()[yfrom][xfrom] = new BlankSquare();

        return board.getBoard();
    }
}
