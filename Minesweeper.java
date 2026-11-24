import java.util.Scanner;
import java.util.Random;

public class Minesweeper {

    public static void main(String[] args) {

        int[][] checkerboard = new int[11][11];
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("9x9 grid, with 10 mines");
        System.out.println();
        for (int row = 0; row < checkerboard.length; row++) {
            for (int column = 0; column < checkerboard[row].length; column++) {
                checkerboard[row][column] = 1;
                if (row == 0 && column == 0)
                    System.out.print("   ");
                if (row == 0 && column != 0 && column != 10)
                    System.out.print(" " + (column));
                if (row == 1 && column == 0)
                    System.out.print("  +-------------------+");
                if (column == 10 && row != 0 && row != 1)
                    System.out.print(" |");
                if (column == 0 && row != 0 && row != 1)
                    System.out.print((row - 1) + " |");
                if (row != 0 && row != 1 && column != 0 && column != 10) {
                    if (checkerboard[row][column] == 1 || checkerboard[row][column] == 4) {
                        System.out.print(" #");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("  +-------------------+");

        int mines = 10;
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        switch (name) {
            case "Alina":
                mines = 80;
                break;
            case "your name":
                mines = 80;
                break;
            case "Jeevith":
                mines = 80;
                break;
            case "code broken":
                mines = 1;
                break;

        }
        Random random = new Random();
        while (mines > 0) {
            int mineRow = random.nextInt(9) + 2;
            int mineColumn = random.nextInt(9) + 1;
            if (checkerboard[mineRow][mineColumn] == 1) {
                checkerboard[mineRow][mineColumn] = 4;
                mines--;
            }
        }

        int game = 1;
        while (game == 1) {
            System.out.println();
            System.out.println("9x9 grid, with 10 mines");
            System.out.println();
            for (int row = 0; row < checkerboard.length; row++) {
                for (int column = 0; column < checkerboard[row].length; column++) {
                    if (row == 0 && column == 0)
                        System.out.print("   ");
                    if (row == 0 && column != 0 && column != 10)
                        System.out.print(" " + (column));
                    if (row == 1 && column == 0)
                        System.out.print("  +-------------------+");
                    if (column == 10 && row != 0 && row != 1)
                        System.out.print(" |");
                    if (column == 0 && row != 0 && row != 1)
                        System.out.print((row - 1) + " |");
                    if (row != 0 && row != 1 && column != 0 && column != 10) {
                        if (checkerboard[row][column] == 1 || checkerboard[row][column] == 4) {
                            System.out.print(" #");
                        }
                        if (checkerboard[row][column] == 5) {
                            System.out.print(" X");
                            game--;
                        }
                        if (checkerboard[row][column] == 3 || checkerboard[row][column] == 7) {
                            System.out.print(" F");
                        }
                        if (checkerboard[row][column] == 6) {
                            if (countAdjacentMines(checkerboard, row, column) == 0) {
                                System.out.print("  ");
                            } else {
                                System.out.print(" " + countAdjacentMines(checkerboard, row, column));
                            }
                        }
                    }
                }
                System.out.println();
            }
            System.out.println("  +-------------------+");
            System.out.println();
            switch (name) {
                case "Vihaan":
                    System.out.println("Good Day, Mr. Pandey");
                    break;
                case "Player":
                    System.out.println("Easter Egg");
                    break;
                case "Alina":
                    System.out.println("Watch, Alina, I am certain you will hit a mine first try");
                    break;
                case "Darth Vader":
                    System.out.println("I am your father");
                    break;
                case "jeevith":
                    System.out.println("Hola, Jeevith");
                    break;
                case "Gray":
                    System.out.println("This is the best project");
                    break;
                case "code":
                    System.out.println(
                            ". ... -.-. .-. .. -... . / -.-. --- -.. . / -... .-. --- -.- . -. / .--. .- .-. .- / --. .- -. .- .-. / -.-. .- -.. .- / ...- . --..");
                    break;
            }
            boolean safesRevealed = true;
            for (int row = 2; row <= 10; row++) {
                for (int column = 1; column <= 9; column++) {
                    if (checkerboard[row][column] == 3 || checkerboard[row][column] == 5
                            || checkerboard[row][column] == 1) {
                        safesRevealed = false;
                        break;
                    }

                }
                if (!safesRevealed == true)
                    break;
            }

            if (safesRevealed == true) {
                System.out.println("You win!" + " " + name);
                game = 0;
            }

            if (game == 0) {
                if (safesRevealed == false) {
                    System.out.println("Ha ha ha! Game over!" + " " + name);
                }
                System.out.println("Would you like to play again, " + name + "? (y/n)");
                String playAgain = scanner.next();
                if (playAgain.equals("y")) {
                    game = 1;
                    for (int row = 0; row < checkerboard.length; row++) {
                        for (int column = 0; column < checkerboard[row].length; column++) {
                            checkerboard[row][column] = 1;
                            if (row == 0 && column == 0)
                                System.out.print("   ");
                            if (row == 0 && column != 0 && column != 10)
                                System.out.print(" " + (column));
                            if (row == 1 && column == 0)
                                System.out.print("  +-------------------+");
                            if (column == 10 && row != 0 && row != 1)
                                System.out.print(" |");
                            if (column == 0 && row != 0 && row != 1)
                                System.out.print((row - 1) + " |");
                            if (row != 0 && row != 1 && column != 0 && column != 10) {
                                if (checkerboard[row][column] == 1 || checkerboard[row][column] == 4) {
                                    System.out.print(" #");
                                }
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("  +-------------------+");

                    mines = 10;
                    switch (name) {
                        case "Alina":
                            mines = 80;
                            break;
                        case "your name":
                            mines = 80;
                            break;
                        case "jeevith":
                            mines = 80;
                            break;
                    }
                    random = new Random();
                    while (mines > 0) {
                        int mineRow = random.nextInt(9) + 2;
                        int mineColumn = random.nextInt(9) + 1;
                        if (checkerboard[mineRow][mineColumn] == 1) {
                            checkerboard[mineRow][mineColumn] = 4;
                            mines--;
                        }
                    }

                } else {
                    System.out.println("How disappointing!");
                    break;
                }
            }

            System.out.print("Enter row then column (e.g. 1 2):");
            int pickRow = scanner.nextInt();
            int pickColumn = scanner.nextInt();
            if (pickColumn < 1 || pickColumn < 9) {
                System.out.println("Invalid column. Please enter a column between 1 and 9.");
                continue;
            }
            if (pickRow < 1 || pickRow > 9) {
                System.out.println("Invalid row. Please enter a row between 1 and 9.");
                continue;
            }
            System.out.print("Then enter action, r to reveal, f to flag:");
            String action = scanner.next();
            if (!action.equals("r") && !action.equals("f")) {
                System.out.println("Invalid action. Please enter 'r' to reveal or 'f' to flag.");
                continue;
            }

            if (action.equals("r")) {
                int selectedRow = pickRow + 1;
                if (checkerboard[selectedRow][pickColumn] == 4 || checkerboard[selectedRow][pickColumn] == 7) {
                    System.out.println("You hit a mine! ha ha ha!");
                    checkerboard[selectedRow][pickColumn] = 5;
                } else if (checkerboard[selectedRow][pickColumn] == 1) {
                    revealArea(checkerboard, selectedRow, pickColumn);
                }
            }
            if (action.equals("f")) {
                if (checkerboard[pickRow + 1][pickColumn] == 4)
                    checkerboard[pickRow + 1][pickColumn] = 7;
                else if (checkerboard[pickRow + 1][pickColumn] == 7)
                    checkerboard[pickRow + 1][pickColumn] = 4;
                if (checkerboard[pickRow + 1][pickColumn] == 1) {
                    checkerboard[pickRow + 1][pickColumn] = 3;
                } else if (checkerboard[pickRow + 1][pickColumn] == 3) {
                    checkerboard[pickRow + 1][pickColumn] = 1;
                }

            }

        }
    }

    private static int countAdjacentMines(int[][] board, int row, int column) {
        int count = 0;

        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            for (int columnOffset = -1; columnOffset <= 1; columnOffset++) {
                if (rowOffset == 0 && columnOffset == 0) {
                    continue;
                }

                int neighborRow = row + rowOffset;
                int neighborColumn = column + columnOffset;

                if (neighborRow >= 2 && neighborRow <= 10
                        && neighborColumn >= 1 && neighborColumn <= 9
                        && (board[neighborRow][neighborColumn] == 4
                                || board[neighborRow][neighborColumn] == 7)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void revealArea(int[][] board, int row, int column) {
        if (row < 2 || row > 10 || column < 1 || column > 9 || board[row][column] != 1) {
            return;
        }

        board[row][column] = 6;
        if (countAdjacentMines(board, row, column) != 0) {
            return;
        }

        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            for (int columnOffset = -1; columnOffset <= 1; columnOffset++) {
                if (rowOffset != 0 || columnOffset != 0) {
                    revealArea(board, row + rowOffset, column + columnOffset);
                }
            }
        }
    }
}
