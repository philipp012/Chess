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
        // game loop
        while (true) {
            board.printBoard();
            // Whites turn
            move =  player1.getMove();
            xfrom = move[0][0];
            yfrom = move[0][1];
            xto = move[1][0];
            yto = move[1][1];
            

            // check if from field is white and to field isn't
            if (board.getBoard()[yfrom][xfrom].getColor().equals(COLOR.WHITE)) {
                if (!board.getBoard()[yto][xto].getColor().equals(COLOR.WHITE)) {
                    board.setBoard(board.getBoard()[yfrom][xfrom].move(move, board));
                }
            }
            moves++;

            System.out.println("Moves: " + moves);
            board.printBoardReversed();


            // Blacks turn
            move = player2.getMove();
            xfrom = move[0][0];
            yfrom = move[0][1];
            xto = move[1][0];
            yto = move[1][1];


            // check if from field is black and to field isn't
            if (board.getBoard()[yfrom][xfrom].getColor().equals(COLOR.BLACK)) {
                if (!board.getBoard()[yto][xto].getColor().equals(COLOR.BLACK)) {
                    board.setBoard(board.getBoard()[yfrom][xfrom].move(move, board));
                }
            }
            moves++;
            System.out.println("Moves: " + moves);
        }
    }
}
