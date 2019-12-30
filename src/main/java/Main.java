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
        // game loop
        while (true) {
            board.printBoard();
            // Whites turn
            int[][] move = player1.getMove();
            int xfrom = move[0][0];
            int yfrom = move[0][1];
            int xto = move[1][0];
            int yto = move[1][1];
            

            // check if from field is white and to field isn't
            if (board.getBoard()[xfrom][yfrom].getColor().equals(COLOR.WHITE)) {
                if (!board.getBoard()[xto][yto].getColor().equals(COLOR.WHITE)) {
                    board.setBoard(board.getBoard()[xfrom][xto].move(move, board));
                }
            }

            // Blacks turn
        }
    }
}
