package Preperation;

import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //startLetter    (char)startLetter + col //startLetter
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String[][] matrix = new String[rows][cols];
        char startLetter = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String palindrome = "" + startLetter + (char)(startLetter+col) + startLetter;
                matrix[row][col] = palindrome;
            }
            startLetter = (char)(startLetter +1);
        }

        printMatrix(matrix,rows,cols);
    }

    private static void fillMatrix(int[][] matrix, int size, Scanner scanner) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    public static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

