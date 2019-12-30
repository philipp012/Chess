import Enums.COLOR;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private COLOR color;
    private static final Scanner scanner = new Scanner(System.in);
    private static final char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    String getInput() {
        String input =  scanner.nextLine();
        return input;
    }

    int[][] getMove() {
        /*
        * Get int matrix as follows
        * move[[xfrom][yfrom]][[xto][yto]]
        */

        boolean valid = false;
        int[] from = new int[2];
        int[] to = new int[2];

        while (!valid) {
            System.out.print(this.color + "'s turn: ");
            String input = getInput().toUpperCase();
            if (checkInputValidity(input)) {
                valid = true;
                for (int i = 0; i < LETTERS.length; i++) {
                    if (LETTERS[i] == input.charAt(0)) {
                        from[0] = i;
                    }
                    if (LETTERS[i] == input.charAt(3)) {
                        to[0] = i;
                    }
                }
                from[1] = movementCorrector(Character.getNumericValue(input.charAt(1)) -1);
                to[1] = movementCorrector(Character.getNumericValue(input.charAt(4)) -1);
            } else {
                System.out.println("Invalid input");
            }
        }
        return new int[][]{from, to};
    }

    private int movementCorrector(int input) {
        switch (input) {
            case 0:
                return 7;
            case 1:
                return 6;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            case 7:
                return 0;
        }
        throw new InputMismatchException();
    }

    private boolean checkInputValidity(String input) {
        if (input.length() != 5) {
            return false;
        }
        boolean valid = false;
        for (char c : LETTERS) {
            if (c == input.charAt(0)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            return false;
        }
        valid = false;
        for (char c : LETTERS) {
            if (c == input.charAt(3)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            return false;
        }
        int intFrom = Integer.parseInt(String.valueOf(input.charAt(1)));
        int intTo = Integer.parseInt(String.valueOf(input.charAt(4)));
        return 0 <= intFrom && !(intFrom > 9 | 0 > intTo) && intTo <= 9;
    }


}
