import Enums.COLOR;

import java.util.List;

import static java.lang.Math.abs;

public class Pawn extends Piece {
    public Pawn(COLOR color, String symbol) {
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

        int[][] lastMove;

        // check move validity
        if (abs(yto - yfrom) <= 2 && abs(xfrom - xto) <= 1) {
            // upwards
            if (yfrom > yto && this.getColor().equals(COLOR.WHITE)) {
                // 1 step forward
                if (yfrom - yto == 1 && board.getBoard()[yto][xto].getColor().equals(COLOR.NONE) && xfrom == xto) {
                    moveResponse.setValid(true);
                    return moveResponse;
                }
                // 2 steps forward
                if (this.getColor().equals(COLOR.WHITE) && yfrom == 6 && board.getBoard()[yto + 1][xto].getColor().equals(COLOR.NONE) && board.getBoard()[yto][xto].getColor().equals(COLOR.NONE)) {
                    moveResponse.setValid(true);
                    return moveResponse;
                }

                // en passant
                if (yfrom == 3) {
                    if (board.getBoard()[yto+1][xto].getSymbol().equals("\u2659")) {
                        lastMove = moveTracker.get(moveTracker.size()-1);
                        if (lastMove[0][1] == yto-1 && lastMove[0][0] == xto && lastMove[1][1] == yto+1 && lastMove[1][0] == xto) {
                            moveResponse.setValid(true);
                            moveResponse.setEnPassant(true);
                            return moveResponse;
                        }
                    }
                }
            }
            // downwards
            else if (yto > yfrom && this.getColor().equals(COLOR.BLACK)){
                // 1 step forward
                if (yto - yfrom == 1 && board.getBoard()[yto][xto].getColor().equals(COLOR.NONE)) {
                    moveResponse.setValid(true);
                    return moveResponse;
                }
                // 2 steps forward
                if (yfrom == 1 && board.getBoard()[yto -1][xto].getColor().equals(COLOR.NONE) && board.getBoard()[yto][xto].getColor().equals(COLOR.NONE)) {
                    moveResponse.setValid(true);
                    return moveResponse;
                }

                // en passant
                if (yfrom == 4) {
                    if (board.getBoard()[yto-1][xto].getSymbol().equals("\u265F")) {
                        lastMove = moveTracker.get(moveTracker.size()-1);
                        if (lastMove[0][1] == yto+1 && lastMove[0][0] == xto && lastMove[1][1] == yto-1 && lastMove[1][0] == xto) {
                            moveResponse.setValid(true);
                            moveResponse.setEnPassant(true);
                            return moveResponse;
                        }
                    }
                }
            }

            // beating
            if (!board.getBoard()[yto][xto].getColor().equals(this.getColor()) && !board.getBoard()[yto][xto].getColor().equals(COLOR.NONE)) {
                moveResponse.setValid(true);
                return moveResponse;
            }

        }
        // error
        return moveResponse;
    }
}
