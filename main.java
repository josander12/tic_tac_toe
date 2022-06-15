import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            //Task 1: Create an array with three rows of '_' characters.
            char board[][] = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
            };

            printBoard(board);

            for (int i=0; i < 9; i++) {

                if (i % 2 == 0) {
                    System.out.println("Turn X:");
                    int[] choice = askUser(board);
                    board[choice[0]][choice[1]] = 'X';
                } else {
                    System.out.println("Turn O:");
                    int[] choice = askUser(board);
                    board[choice[0]][choice[1]] = 'O';
                }

                printBoard(board);
                int count = checkWin(board);

                if (count == 3) {
                    System.out.println("Player X wins!");
                    break;
                } else if (count == -3) {
                    System.out.println("Player O wins!");
                    break;
                }

            }

            System.out.println("Its a tie!");
             
            scan.close();
        }

    /**
     * Function name: printBoard
     * 
     * @param board (char[][])
     * 
     * Inside the function:
     *  1. Formats and prints the board in a 3x3 grid.
     */
    public static void printBoard(char[][] board) {

        for (int i=0; i < board.length; i++) {
            System.out.println(" ");
            for (int j=0; j < board[i].length; j++) {
                if (j == 0) {
                    System.out.print("\t");
                }
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println("\n");
    }

    /**
     * Function name: askUser
     * 
     * @param board (char[][])
     * @return spot (int[])
     * 
     * Inside the function:
     *  1. Requests input from user for row and column of spot to play
     *  2. Checks if the spot is within range of the board.  If not, it requests new selection.
     *  3. Checks if the spot is taken.  If so, requests the user choose again.
     *  4. Returns the row and column in an int[] array.
     */

    public static int[] askUser(char[][] board) {
        int[] spot = new int[2];

        System.out.print("  - pick a row and column number: ");

        while (true) {
            int row = scan.nextInt() - 1;
            int column = scan.nextInt() - 1;
            while (row < 0 || row > 2 || column < 0 || column > 2) {
                System.out.print("    You made an invalid selection. Please try again: ");
                row = scan.nextInt() - 1;
                column = scan.nextInt() - 1;
            }
            spot[0] = row;
            spot[1] = column;
            if (board[spot[0]][spot[1]] == '-') {
                break;
            } 
            System.out.print("  - That spot has already been chosen. Please enter coordinates again: ");
        }

        return spot;
    }

    /**
     * Function name: checkWin
     * @param board (char[][])
     * @return int count
     * 
     * Inside the function:
     *  1. Checks every row for a straight X or straight O
     *  2. Checks every column for a straight X or straight O
     *  3. Checks left diagonal for a straight X or straight O
     *  4. Checks right diagonal for a straight X or straight O
     *  5. At any point if count == 3 or -3, it will be returned
     *  6. If it hasn't been returned, then whatever value it is at the end of the function will be returned.
     */

    public static int checkWin(char[][] board) {
        int count = 0;

        for (int i=0; i < board.length; i++) {

            /* Checking every row for a straight X or straight O */
            for (int j=0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    ++count;
                } else if (board[i][j] == 'O') {
                    --count;
                }
            }
            if (count == 3 || count == -3) {
                return count;
            }
            count = 0;

            /* Checking every column for a straight X or straight O */
            for (int j=0; j < board[i].length; j++) {
                if (board[j][i] == 'X') {
                    ++count;
                } else if (board[j][i] == 'O') {
                    --count;
                }
            }
            if (count == 3 || count == -3) {
                return count;
            }
            count = 0;            
        }
        
        /* Checking left diagonal for a straight X or straight O */
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X') {
                ++count;
            } else if (board[i][i] == 'O') {
                --count;
            }
        }
        if (count == 3 || count == -3) {
            return count;
        }
        count = 0;

        /* Checking right diagonal for a straight X or straight O */
        for (int i = 0; i < board.length; i++) {
            if (board[2 - i][i] == 'X') {
                ++count;
            } else if (board[2 - i][i] == 'O') {
                --count;
            }
        }
        if (count == 3 || count == -3) {
            return count;
        }

        return 0;
    }
     

}
