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

        System.out.print("Name of Player 1: ");
        player1.setName(player1.getInput());
        while (player1.getColor() == null) {
            String color = player1.getInput().trim().toLowerCase();
            System.out.print("Do you want to play as white or as black <w/b> ");
            if (color.equals("w")) {
                player1.setColor(COLOR.WHITE);
                player2.setColor(COLOR.BLACK);
            } else if (color.equals("b")) {
                player1.setColor(COLOR.BLACK);
                player2.setColor(COLOR.WHITE);
            } else {
                System.out.println("Please pick w or b");
            }
        }

        System.out.print("Name of Player 2: ");
        player2.setName(player2.getInput());

        Board board = new Board();
        board.setUp();
        int moves = 0;
        while (true) {
            if (player1.getColor().equals(COLOR.WHITE)) {
                int[] from = player1.getMove()[0];
                int[] to = player1.getMove()[1];

                // check if from field is white and to field isn't
                if (board.getBoard()[from[0]][from[1]].getColor().equals(player1.getColor()) && !board.getBoard()[to[0]][to[1]].getColor().equals(player1.getColor())) {
                    board.getBoard()[from[0]][from[1]].move(to);
                }
            } else {
            }
        }
    }


}
