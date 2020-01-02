import Enums.COLOR;

public class Rook extends Piece {
    public Rook(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }

    @Override
    public Piece[][] move(int[][] move, Board board) {
        int xfrom = move[0][0];
        int yfrom = move[0][1];
        int xto = move[1][0];
        int yto = move[1][1];

        // vertical
        if (xfrom == xto && yfrom != yto) {
            int counter = yfrom;
            // up
            if (yfrom > yto) {
                counter--;
                while (counter > yto + 1) {
                    // check if field is free
                    if (!board.getBoard()[counter][xfrom].getColor().equals(COLOR.NONE)) {
                        return board.getBoard();
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
                        return board.getBoard();
                    }
                    counter++;
                }
            }
        }
        // horizontal
        else if (yfrom == yto && xfrom != xto) {
            int counter = xfrom;
            //right
            if (xfrom < xto) {
                counter++;
                while (counter < xto - 1) {
                    // check if field is free
                    if (!board.getBoard()[yfrom][counter].getColor().equals(COLOR.NONE)) {
                        return board.getBoard();
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
                        return board.getBoard();
                    }
                    counter--;
                }
            }
        }

        // execute move
        board.getBoard()[yto][xto] = this;
        board.getBoard()[yfrom][xfrom] = new BlankSquare();
        return board.getBoard();
    }
}
