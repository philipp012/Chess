import Enums.COLOR;

public class Rook extends Piece {
    public Rook(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }

    @Override
    public boolean checkMove(int[][] move, Board board) {
        int xfrom = move[0][0];
        int yfrom = move[0][1];
        int xto = move[1][0];
        int yto = move[1][1];

        // vertical
        if (xfrom == xto) {
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
        else if (yfrom == yto) {
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

        // execute move
        return false;
    }
}
