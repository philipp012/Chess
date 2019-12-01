import Enums.COLOR;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Player {
    private COLOR color;
    private String name;
    private static final Scanner scanner = new Scanner(System.in);
    private static final char LETTERS[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',};

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getInput() {
        String input =  scanner.nextLine();
        scanner.close();
        return input;
    }

    int[][] getMove() {
        boolean valid = false;
        int[] from = new int[2];
        int[] to = new int[2];
        while (!valid) {
            System.out.print(this.color + "'s turn: ");
            String input = getInput();
            if (checkInputValidity(input)) {
                valid = true;
                from[0] = input.charAt(0);
                from[1] = input.charAt(1);
                to[0] = input.charAt(3);
                to[1] = input.charAt(4);
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
        if (0 > intFrom || intFrom > 9 | 0 > intTo || intTo > 9) {
            return false;
        }

        return true;
    }


}
