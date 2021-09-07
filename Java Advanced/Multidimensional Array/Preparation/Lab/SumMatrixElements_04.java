package Preperation;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int [][] matrix = readMatrix(rows,cols,scanner);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getElementsSum(matrix));


    }

    public static int getElementsSum(int [][] matrix){
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
                    if (current == number){
                        out.add(new int[]{row,col});
                    }
                }
            }

            return out;
        }

        private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
            if (firstMatrix.length != secondMatrix.length){
                return false;
            }

            for (int row = 0; row < firstMatrix.length; row++) {
                int [] firstArray = firstMatrix[row];
                int [] secondArray = secondMatrix [row];

                if (firstArray.length != secondArray.length){
                    return false;
                }

                for (int col = 0; col < firstArray.length; col++) {
                    if(firstArray[col] != secondArray[col]){
                        return false;
                    }
                }
            }

            return true;
        }


        public static int[][] readMatrix(int rows,int cols,Scanner scanner){
            int [] [] matrix = new int [rows][cols];
            for (int row = 0; row < rows; row++) {
                matrix [row] = readArray(scanner.nextLine());
            }
            return matrix;
        }



        public static int [] readArray (String line){
            return Arrays.stream(line.split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
}
