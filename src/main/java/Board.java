import Enums.COLOR;

class Board {
    private static final int NUMBERS[] = {1,2,3,4,5,6,7,8};
    private static final char LETTERS[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',};

    private Piece[][] board = new Piece[8][8];

    void setUp() {
        board[0][0] = new Rook(COLOR.WHITE, "\u2656");
        board[0][1] = new Knight(COLOR.WHITE, "\u2658");
        board[0][2] = new Bishop(COLOR.WHITE, "\u2657");
        board[0][3] = new Queen(COLOR.WHITE, "\u2655");
        board[0][4] = new King(COLOR.WHITE, "\u2654");
        board[0][5] = new Bishop(COLOR.WHITE, "\u2657");
        board[0][6] = new Knight(COLOR.WHITE, "\u2658");
        board[0][7] = new Rook(COLOR.WHITE, "\u2656");

        // white pawns
        for(int i = 0; i < 8; i++){
            board[1][i] = new Pawn(COLOR.WHITE, "\u2659");
        }

        // filling blank spaces with placeholder pieces
        for(int i = 2; i < 6; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new BlankSquare();
            }
        }

        board[7][0] = new Rook(COLOR.BLACK, "\u265C");
        board[7][1] = new Knight(COLOR.BLACK, "\u265E");
        board[7][2] = new Bishop(COLOR.BLACK, "\u265D");
        board[7][3] = new Queen(COLOR.BLACK, "\u265B");
        board[7][4] = new King(COLOR.BLACK, "\u265A");
        board[7][5] = new Bishop(COLOR.BLACK, "\u265D");
        board[7][6] = new Knight(COLOR.BLACK, "\u265E");
        board[7][7] = new Rook(COLOR.BLACK, "\u265C");

        // black pawns
        for(int i = 0; i < 8; i++){
            board[6][i] = new Pawn(COLOR.BLACK, "\u265F");
        }
    }

    public void printBoard() {
        System.out.print("\n   ");
        for(char i: LETTERS){
            System.out.print("\u2001\u2001" + i + "\u2009\u2009\u2001");
        }
        System.out.print("\n   ");
        for(int i = 0; i < 8; i++){
            System.out.print("-------");
        }
        System.out.print("\n");
        for(int i = 0; i < 8; i++){
            System.out.print("  " + (8 - i) + " |");
            for(Piece j: board[i]){
                System.out.print(" " + j.getSymbol() + "  | ");
            }
            System.out.print("" + (8 - i));
            System.out.print("\n   ");
            for(int j = 0; j < 8; j++){
                System.out.print("-------");
            }
            System.out.print("\n");
        }
        System.out.print("   ");
        for(char i: LETTERS){
            System.out.print("\u2001\u2001" + i + "\u2009\u2009\u2001");
        }
        System.out.print("\n\n");
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }
}
