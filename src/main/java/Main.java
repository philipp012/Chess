import Enums.COLOR;

import java.util.ArrayList;
import java.util.List;

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

        List<int[][]> moveTracker = new ArrayList<int[][]>();

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
            while (true) {
                move = player1.getMove();
                xfrom = move[0][0];
                yfrom = move[0][1];
                xto = move[1][0];
                yto = move[1][1];

                // check if from field is white and to field isn't
                if (board.getBoard()[yfrom][xfrom].getColor().equals(COLOR.WHITE)) {
                    if (!board.getBoard()[yto][xto].getColor().equals(COLOR.WHITE)) {
                        MoveResponse moveResponse = board.getBoard()[yfrom][xfrom].checkMove(move, board, moveTracker);
                        if (moveResponse.isValid()) {
                            Piece[][] backUpBoard = board.getBoard();

                            if (moveResponse.isEnPassant()) {
                                board.getBoard()[yto + 1][xto] = new BlankSquare();
                            } else if (moveResponse.isCastlingKing()) {
                                board.getBoard()[yto][xto-1] = new Rook(COLOR.WHITE, "\u265C");
                                board.getBoard()[yto][xto+1] = new BlankSquare();
                            } else if (moveResponse.isCastlingQueen()) {
                                board.getBoard()[yto][xto+1] = new Rook(COLOR.WHITE, "\u265C");
                                board.getBoard()[yto][xto-2] = new BlankSquare();
                            }

                            // set move
                            board.getBoard()[yto][xto] = board.getBoard()[yfrom][xfrom];
                            board.getBoard()[yfrom][xfrom] = new BlankSquare();


                            if (checkCheck(COLOR.WHITE, board, moveTracker)) {
                                board.setBoard(backUpBoard);
                                System.out.println("You would be in check!");
                            } else {
                                // pawn promotion
                                if (board.getBoard()[yto][xto].getSymbol().equals("\u2659") && yto == 0) {
                                    System.out.print("Pawn Promotion: ");
                                    String input = player1.getInput();
                                    switch (input.toLowerCase().charAt(0)) {
                                        case 'r':
                                            board.getBoard()[yto][xto] = new Rook(COLOR.WHITE, "\u265C");
                                            break;
                                        case 'k':
                                            board.getBoard()[yto][xto] = new Knight(COLOR.WHITE, "\u265E");
                                            break;
                                        case 'b':
                                            board.getBoard()[yto][xto] = new Bishop(COLOR.WHITE, "\u265D");
                                            break;
                                        default:
                                            board.getBoard()[yto][xto] = new Queen(COLOR.WHITE, "\u265B");
                                    }
                                }

                                moveTracker.add(move);

                                moves++;
                                break;
                            }
                        } else {
                            System.out.println("invalid move");
                        }
                    } else {
                        System.out.println("invalid move");
                    }
                } else {
                    System.out.println("invalid move");
                }
            }

            if (checkCheck(COLOR.BLACK, board, moveTracker)) {
                System.out.println("Check!");
            }

            System.out.println("Moves: " + moves);
            board.printBoard();


            // Blacks turn
            while (true) {
                move = player2.getMove();
                xfrom = move[0][0];
                yfrom = move[0][1];
                xto = move[1][0];
                yto = move[1][1];
                // check if from field is white and to field isn't
                if (board.getBoard()[yfrom][xfrom].getColor().equals(COLOR.BLACK)) {
                    if (!board.getBoard()[yto][xto].getColor().equals(COLOR.BLACK)) {
                        MoveResponse moveResponse = board.getBoard()[yfrom][xfrom].checkMove(move, board, moveTracker);
                        if (moveResponse.isValid()) {
                            Piece[][] backUpBoard = board.getBoard();

                            if (moveResponse.isEnPassant()) {
                                board.getBoard()[yto - 1][xto] = new BlankSquare();
                            } else if (moveResponse.isCastlingKing()) {
                                board.getBoard()[yto][xto-1] = new Rook(COLOR.BLACK, "\u2656");
                                board.getBoard()[yto][xto+1] = new BlankSquare();
                            } else if (moveResponse.isCastlingQueen()) {
                                board.getBoard()[yto][xto+1] = new Rook(COLOR.BLACK, "\u2656");
                                board.getBoard()[yto][xto-2] = new BlankSquare();
                            }
                            // set move
                            board.getBoard()[yto][xto] = board.getBoard()[yfrom][xfrom];
                            board.getBoard()[yfrom][xfrom] = new BlankSquare();
                            if (checkCheck(COLOR.BLACK, board, moveTracker)) {
                                board.setBoard(backUpBoard);
                                System.out.println("You would be in check!");
                            } else {
                                // pawn promotion
                                if (board.getBoard()[yto][xto].getSymbol().equals("\u2659") && yto == 7) {
                                    System.out.print("Pawn Promotion: ");
                                    String input = player2.getInput();
                                    switch (input.toLowerCase().charAt(0)) {
                                        case 'r':
                                            board.getBoard()[yto][xto] = new Rook(COLOR.BLACK, "\u2656");
                                            break;
                                        case 'k':
                                            board.getBoard()[yto][xto] = new Knight(COLOR.BLACK, "\u2658");
                                            break;
                                        case 'b':
                                            board.getBoard()[yto][xto] = new Bishop(COLOR.BLACK, "\u2657");
                                            break;
                                        default:
                                            board.getBoard()[yto][xto] = new Queen(COLOR.BLACK, "\u2655");
                                    }
                                }

                                moveTracker.add(move);

                                moves++;
                                break;
                            }
                        } else {
                            System.out.println("invalid move");
                        }
                    } else {
                        System.out.println("invalid move");
                    }
                } else {
                    System.out.println("invalid move");
                }
            }

            if (checkCheck(COLOR.WHITE, board, moveTracker)) {
                System.out.println("Check!");
            }

            System.out.println("Moves: " + moves);
        }
    }

    private static boolean checkCheck(COLOR color, Board board, List<int[][]> moveTracker) {
        for (int kingY = 0; kingY < 8; kingY++) {
            for (int kingX = 0; kingX < 8; kingX++) {
                // check if field contains king-object of the targeted color
                if (board.getBoard()[kingY][kingX].getSymbol().equals("\u265A") || board.getBoard()[kingY][kingX].getSymbol().equals("\u2654") && board.getBoard()[kingY][kingX].getColor().equals(color)) {

                    for (int attackerY = 0; attackerY < 8; attackerY++) {
                        for (int attackerX = 0; attackerX < 8; attackerX++) {
                            // check if field is of opposite color
                            if (!board.getBoard()[attackerY][attackerX].getColor().equals(COLOR.NONE)) {
                                if (!board.getBoard()[attackerY][attackerX].getColor().equals(color)) {
                                    // check if attacking field isn't king
                                    if (!board.getBoard()[attackerY][attackerX].getSymbol().equals("\u2654") && !board.getBoard()[attackerY][attackerX].getSymbol().equals("\u265A")) {
                                        int[] from = new int[2];
                                        int[] to = new int[2];

                                        from[0] = attackerX;
                                        from[1] = attackerY;
                                        to[0] = kingX;
                                        to[1] = kingY;


                                        if (board.getBoard()[attackerY][attackerX].checkMove(new int[][]{from, to}, board, moveTracker).isValid()) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }
}
