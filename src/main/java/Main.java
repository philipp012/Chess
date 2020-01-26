import Enums.COLOR;

public class Main {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        System.out.println("Console Chess");
        System.out.println("=============");

        Player player1 = new Player();
        Player player2 = new Player();
        player1.setColor(COLOR.WHITE);
        player2.setColor(COLOR.BLACK);

        Board board = new Board();
        board.setUp();
        int moves = 0;
        int[][] move;
        int xfrom;
        int yfrom;
        int xto;
        int yto;

        boolean checker;
        // game loop
        while (true) {
            board.printBoard();

            checker = false;


            // Whites turn
            while (!checker) {
                move = player1.getMove();
                xfrom = move[0][0];
                yfrom = move[0][1];
                xto = move[1][0];
                yto = move[1][1];

                // check if from field is white and to field isn't
                if (board.getBoard()[yfrom][xfrom].getColor().equals(COLOR.WHITE)) {
                    if (!board.getBoard()[yto][xto].getColor().equals(COLOR.WHITE)) {
                        if (board.getBoard() != board.getBoard()[yfrom][xfrom].move(move, board) && board.getBoard()[yfrom][xfrom].move(move, board) != null) {
                            board.setBoard(board.getBoard()[yfrom][xfrom].move(move, board));
                            moves++;
                            checker = true;
                        } else {
                            System.out.println("invalid move");
                        }
                    }
                }
            }

            // checkCheck(COLOR.BLACK, board);

            System.out.println("Moves: " + moves);
            board.printBoard();


            checker = false;
            // Blacks turn
            while (!checker) {
                move = player2.getMove();
                xfrom = move[0][0];
                yfrom = move[0][1];
                xto = move[1][0];
                yto = move[1][1];
                // check if from field is white and to field isn't
                if (board.getBoard()[yfrom][xfrom].getColor().equals(COLOR.BLACK)) {
                    if (!board.getBoard()[yto][xto].getColor().equals(COLOR.BLACK)) {
                        if (board.getBoard() != board.getBoard()[yfrom][xfrom].move(move, board) && board.getBoard()[yfrom][xfrom].move(move, board) != null) {
                            board.setBoard(board.getBoard()[yfrom][xfrom].move(move, board));
                            moves++;
                            checker = true;
                        } else {
                            System.out.println("invalid move");
                        }
                    }
                }

                System.out.println("Moves: " + moves);
            }
        }

        /*private static void checkCheck(COLOR color, Board board){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    // check if field contains king-object of the targeted color
                    if (board.getBoard()[i][j].getSymbol().equals('\u265A') | board.getBoard()[i][j].getSymbol().equals('\u2654') && board.getBoard()[i][j].getColor().equals(color)) {

                        for (int attackerX = 0; attackerX < 8; attackerX++) {
                            for (int attackerY = 0; attackerY < 8; attackerY++) {
                                // check if field is of opposite color
                                if (!board.getBoard()[attackerY][attackerX].getColor().equals(COLOR.NONE) || !board.getBoard()[attackerY][attackerX].getColor().equals(color)) {
                                    // check if attacking field isn't king
                                    if (board.getBoard()[attackerY][attackerX].getSymbol().equals('\u2654') || board.getBoard()[attackerY][attackerX].getSymbol().equals('\u265A')) {
                                        int[] from = new int[2];
                                        int[] to = new int[2];

                                        from[0] = attackerX;
                                        from[1] = attackerY;
                                        to[0] = i;
                                        to[1] = j;


                                        if (board.getBoard()[attackerY][attackerX].move(new int[][]{from, to}, board) != null) {
                                            System.out.println("Check!");
                                        }
                                    }
                                }
                            }
                        }

                        break;
                    }
                }
            }*/
    }
}
