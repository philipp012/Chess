import Enums.COLOR;

import java.util.List;

import static java.lang.Math.abs;

public class Knight extends Piece {
    public Knight(COLOR color, String symbol) {
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

        // check if move valid
        if (abs(xto - xfrom) == 2 && abs(yto - yfrom) == 1 || abs(xto - xfrom) == 1 && abs(yto - yfrom) == 2) {
            moveResponse.setValid(true);
            return moveResponse;
        }
        return moveResponse;
    }
}
