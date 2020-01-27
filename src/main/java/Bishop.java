import Enums.COLOR;

import java.util.List;

import static java.lang.Math.abs;

public class Bishop extends Piece {
    public Bishop(COLOR color, String symbol) {
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


        // check if move is valid
        if (abs(xfrom - xto) == abs(yfrom - yto)) {
            // top left
            if (xto < xfrom && yto < yfrom) {
                int xchecker = xfrom - 1;
                for (int i = yfrom - 1; i > yto; i--) {
                    // check if lane is free
                    if (!board.getBoard()[i][xchecker].getColor().equals(COLOR.NONE)) {
                        return moveResponse;
                    }
                    xchecker--;
                }
            }
            // top right
            if (xto > xfrom && yto < yfrom) {
                int xchecker = xfrom + 1;
                for (int i = yfrom - 1; i > yto; i--) {
                    // check if lane is free
                    if (!board.getBoard()[i][xchecker].getColor().equals(COLOR.NONE)) {
                        return moveResponse;
                    }
                    xchecker++;
                }
            }

            // bottom left
            if (xto < xfrom && yto > yfrom) {
                int xchecker = xfrom - 1;
                for (int i = yfrom + 1; i < yto; i++) {
                    // check if lane is free
                    if (!board.getBoard()[i][xchecker].getColor().equals(COLOR.NONE)) {
                        return moveResponse;
                    }
                    xchecker--;
                }
            }

            // bottom right
            if (xto > xfrom && yto > yfrom) {
                int xchecker = xfrom + 1;
                for (int i = yfrom + 1; i < yto; i++) {
                    // check if lane is free
                    if (!board.getBoard()[i][xchecker].getColor().equals(COLOR.NONE)) {
                        return moveResponse;
                    }
                    xchecker++;
                }
            }


            // execute move
            moveResponse.setValid(true);
            return moveResponse;
        }
        return moveResponse;
    }
}
