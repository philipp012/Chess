import Enums.COLOR;

import java.util.List;

import static java.lang.Math.abs;

public class Queen extends Piece {
    public Queen(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }

    @Override
    public boolean checkMove(int[][] move, Board board, List<int[][]> moveTracker) {
        int xfrom = move[0][0];
        int yfrom = move[0][1];
        int xto = move[1][0];
        int yto = move[1][1];

        // vertical
        if (xfrom == xto && yfrom != yto) {
            // up
            if (yfrom > yto) {
                for (int i = yfrom - 1; i > yto; i--) {
                    // check if lane is free
                    if (!board.getBoard()[i][xto].getColor().equals(COLOR.NONE)) {
                        return false;
                    }
                }
                return true;
            }
            // down
            else {
                for (int i = yfrom + 1; i < yto; i++) {
                    // check if lane is free
                    if (!board.getBoard()[i][xto].getColor().equals(COLOR.NONE)) {
                        return false;
                    }
                }
                return true;
            }
        }
        // horizontal
        else if (yfrom == yto && xfrom != xto) {
            //right
            if (xfrom < xto) {
                for (int i = xfrom + 1; i < xto; i++) {
                    // check if lane is free
                    if (!board.getBoard()[yto][i].getColor().equals(COLOR.NONE)) {
                        return false;
                    }
                }
                return true;
            }
            // left
            else {
                for (int i = xfrom - 1; i > xto; i--) {
                    // check if lane is free
                    if (!board.getBoard()[yto][i].getColor().equals(COLOR.NONE)) {
                        return false;
                    }
                }
                return true;
            }
        }

        // diagonal
        else if (abs(xfrom - xto) == abs(yfrom - yto)) {
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
                return true;
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
                return true;
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
                return true;
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
                return true;
            }
        }
        return false;
    }
}
