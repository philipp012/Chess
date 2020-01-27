import Enums.COLOR;

import java.util.List;

public abstract class Piece {
    private COLOR color;
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public boolean checkMove(int[][] move, Board board, List<int[][]> moveTracker) {
        return false;
    }
}
