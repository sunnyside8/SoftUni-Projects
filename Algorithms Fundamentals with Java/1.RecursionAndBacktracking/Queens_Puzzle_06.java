package Recursion_01;

import java.util.Scanner;

public class Queens_Puzzle_06 {
    public static char[][] board = {
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        findQueenPositions(0);

    }

    private static void findQueenPositions(int row) {
        if (row == 8) {
            printSolution();
        } else {

            for (int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueen(row, col);
                    findQueenPositions(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static void removeQueen(int row, int col) {
        board[row][col] = '-';
    }

    private static void putQueen(int row, int col) {
        board[row][col] = '*';
    }

    private static boolean canPlaceQueen(int row, int col) {
        for (int c = 0; c < 8; c++) {
            if(board[row][c] == '*') {
                return false;
            }
        }

        for (int ro = 0; ro < 8; ro++) {
            if(board[ro][col] == '*') {
                return false;
            }
        }

        int r = row, c = col;


        while (r >= 0 && c >= 0) {
            if(board[r--][c--] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while (r < 8 && c < 8) {
            if(board[r++][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while (r >= 0 && c < 8) {
            if(board[r--][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;

        while (r < 8 && c >= 0) {
            if(board[r++][c--] == '*') {
                return false;
            }
        }
        return true;
    }

    private static void printSolution() {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
