package Preperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner.nextLine(), ", ");

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int bestRow = 0;
        int bestCol = 0;

        int[][] matrix = readMatrix(rows, cols, scanner, ", ");
        int maxSum = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum =
                        matrix[row][col]
                                + matrix[row][col + 1]
                                + matrix[row + 1][col]
                                + matrix[row + 1][col + 1];
                if (sum > maxSum){
                    maxSum =sum;
                    bestRow = row;
                    bestCol = col;
                }

            }
        }
        System.out.println(matrix[bestRow][bestCol] + " " + matrix[bestRow][bestCol+1]);
        System.out.println(matrix[bestRow+1][bestCol] + " "+matrix[bestRow+1][bestCol+1]);
        System.out.println(maxSum);

    }

    public static char[][] getMatrixIntersection(char[][] first, char[][] second) {
        char[][] out = new char[first.length][];

        for (int rows = 0; rows < first.length; rows++) {
            out[rows] = new char[first[rows].length];
            for (int col = 0; col < first[rows].length; col++) {
                out[rows][col] = first[rows][col] == second[rows][col]
                        ? first[rows][col] : '*';
            }
        }

        return out;
    }

    private static char[][] readMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }

        }
        return matrix;
    }


    public static int getElementsSum(int[][] matrix) {
        int sum = 0;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int col = 0; col < matrix[rows].length; col++) {
                sum += matrix[rows][col];
            }

        }
        return sum;
    }

    private static List<int[]> getInts(int[][] matrix, int number) {
        List<int[]> out = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == number) {
                    out.add(new int[]{row, col});
                }
            }
        }

        return out;
    }

    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArray = firstMatrix[row];
            int[] secondArray = secondMatrix[row];

            if (firstArray.length != secondArray.length) {
                return false;
            }

            for (int col = 0; col < firstArray.length; col++) {
                if (firstArray[col] != secondArray[col]) {
                    return false;
                }
            }
        }

        return true;
    }


    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);
        }
        return matrix;
    }

    public static int[] readArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int getElementSumWithStream(int[][] matrix) {
        return Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .sum();
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
