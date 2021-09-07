package Preperation;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] firstMatrix = readMatrix(rows,cols,scanner);

        rowsAndCols = readArray(scanner.nextLine());
        rows = rowsAndCols[0];
        cols = rowsAndCols[1];

        int [] [] secondMatrix = readMatrix(rows,cols,scanner);

        if (matricesAreEqual(firstMatrix,secondMatrix)){
            System.out.println("equal");
        } else{
            System.out.println("not equal");
        }

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
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
