import Enums.COLOR;

import java.util.List;

public class Rook extends Piece {
    public Rook(COLOR color, String symbol) {
        this.setSymbol(symbol);
        this.setColor(color);
    }

    @Override
    public MoveResponse checkMove(int[][] move, Board board, List<int[][]> moveTracker) {
        int xfrom = move[0][0];
        int yfrom = move[0][1];
        int xto = move[1][0];
        int yto = move[1][1];

        MoveResponse moveResponse = new MoveResponse();
        moveResponse.setEnPassant(false);
        moveResponse.setCastlingKing(false);
        moveResponse.setValid(false);

        // vertical
        if (xfrom == xto) {
            // up
            if (yfrom > yto) {
                for (int i = yfrom - 1; i > yto; i--) {
                    // check if lane is free
                    if (!board.getBoard()[i][xto].getColor().equals(COLOR.NONE)) {
                        return moveResponse;
                    }
                }
                moveResponse.setValid(true);
                return moveResponse;
            }
            // down
            else {
                for (int i = yfrom + 1; i < yto; i++) {
                    // check if lane is free
                    if (!board.getBoard()[i][xto].getColor().equals(COLOR.NONE)) {
                        return moveResponse;
                    }
                }
                moveResponse.setValid(true);
                return moveResponse;
            }
        }
        // horizontal
        else if (yfrom == yto) {
            //right
            if (xfrom < xto) {
                for (int i = xfrom + 1; i < xto; i++) {
                    // check if lane is free
                    if (!board.getBoard()[yto][i].getColor().equals(COLOR.NONE)) {
                        return moveResponse;
                    }
                }
                moveResponse.setValid(true);
                return moveResponse;
            }
            // left
            else {
                for (int i = xfrom - 1; i > xto; i--) {
                    // check if lane is free
                    if (!board.getBoard()[yto][i].getColor().equals(COLOR.NONE)) {
                        return moveResponse;
                    }
                }
                moveResponse.setValid(true);
                return moveResponse;
            }
        }

        // execute move
        return moveResponse;
    }
}
