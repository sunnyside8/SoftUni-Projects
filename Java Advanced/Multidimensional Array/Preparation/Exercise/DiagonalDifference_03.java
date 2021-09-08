package Preperation;

import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        fillMatrix(matrix, size, scanner);
        int sumPrimary = getSumOfPrimaryDiagonal(matrix, size);
        int sumSecondary = getSumOfSecondaryDiagonal(matrix, size);
        System.out.println(Math.abs(sumPrimary - sumSecondary));

    }

    private static int getSumOfSecondaryDiagonal(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(col == size - row - 1)
               sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static int getSumOfPrimaryDiagonal(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            //for (int col = 0; col < size; col++) {
                //if (row == col){
                    sum += matrix[row][row];
               // }
            //}

        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, int size, Scanner scanner) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
