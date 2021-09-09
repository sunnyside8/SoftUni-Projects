package Preperation;

import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        int [][] matrix = new int[rows][cols];
        fillMatrix(matrix,rows,cols,scanner);
        int [][] bestMatrix = getMaxSubSubMatrix3by3(matrix);
            //new int[3][3];
        System.out.println("Sum = " + getMatrixSum(bestMatrix));
        printMatrix(bestMatrix);



    }
    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int getMatrixSum(int[][] bestMatrix) {
        int sum = 0;
        for (int i = 0; i < bestMatrix.length; i++) {
            for (int j = 0; j < bestMatrix[i].length; j++) {
                sum+= bestMatrix[i][j];
            }
        }

        return sum;
    }

    public static int[][] getMaxSubSubMatrix3by3(int[][] matrix) {
        int maxSum = 0;

        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum =
                                    matrix[row][col]
                                +   matrix[row][col + 1]
                                +   matrix[row][col + 2]
                                +   matrix[row + 1][col]
                                +   matrix[row + 1][col + 1]
                                +   matrix[row + 1][col + 2]
                                +   matrix[row + 2][col]
                        +           matrix[row + 2][col+1]
                        +           matrix[row + 2][col+2];
                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }

            }
        }
        return new int[][]{
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1],matrix[bestRow][bestCol+2]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1],matrix[bestRow+1][bestCol+2]},
                {matrix[bestRow+2][bestCol],matrix[bestRow+2][bestCol+1],matrix[bestRow+2][bestCol+2]}
        };
    }
    private static void fillMatrix(int[][] matrix, int rows,int cols, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
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
