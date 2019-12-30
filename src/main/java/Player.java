import Enums.COLOR;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
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
                from[1] = Character.getNumericValue(input.charAt(1)) -1;
                to[1] = Character.getNumericValue(input.charAt(4)) -1;
            } else {
                System.out.println("Invalid input");
            }
        }
        return new int[][]{from, to};
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
