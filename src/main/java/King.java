import Enums.COLOR;

import java.util.List;

import static java.lang.Math.abs;

public class King extends Piece {
    public King(COLOR color, String symbol) {
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


        // check validity
        if (abs(xfrom - xto) == 1 && abs(yfrom - yto) == 1 || abs(xfrom - xto) == 0 && abs(yfrom - yto) == 1 || abs(xfrom - xto) == 1 && abs(yfrom - yto) == 0) {
            moveResponse.setValid(true);
            return moveResponse;
        }

        // castling
        if (abs(xfrom - xto) == 2 && yfrom == yto) {
            // castling kingside
            if (xfrom - xto < 0) {
                if (board.getBoard()[yto][xto - 1].getColor().equals(COLOR.NONE) && board.getBoard()[yto][xto + 1].getSymbol().equals("\u265C") || board.getBoard()[yto][xto + 1].getSymbol().equals("\u2656") && board.getBoard()[yto][xto + 1].getColor().equals(this.getColor())) {
                    moveResponse.setCastlingKing(true);
                    moveResponse.setValid(true);
                    return moveResponse;
                }
            } else {
                if (board.getBoard()[yto][xto + 1].getColor().equals(COLOR.NONE) && board.getBoard()[yto][xto - 1].getColor().equals(COLOR.NONE)) {
                    if (board.getBoard()[yto][xto - 2].getSymbol().equals("\u265C") || board.getBoard()[yto][xto - 2].getSymbol().equals("\u2656") && board.getBoard()[yto][xto - 2].getColor().equals(this.getColor())) {
                        moveResponse.setCastlingQueen(true);
                        moveResponse.setValid(true);
                        return moveResponse;
                    }
                }
            }
        }


        if (

                abs(xfrom - xto) == 2 && yfrom == yto && xfrom < xto && board.getBoard()[yfrom][xfrom + 1].

                        getColor().

                        equals(COLOR.NONE)) {
            moveResponse.setValid(true);
            return moveResponse;
        }

        return moveResponse;
    }
}
