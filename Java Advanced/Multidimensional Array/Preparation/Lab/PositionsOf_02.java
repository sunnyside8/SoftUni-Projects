package Preperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = readMatrix(rows,cols,scanner);

        int number = Integer.parseInt(scanner.nextLine());
        List<int[]> output = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == number){
                    output.add(new int[]{row,col});
                }
            }
        }
        if (output.isEmpty()){
            System.out.println("not found");
        } else{
            for (int [] indexes: output) {
                System.out.println(indexes [0] + " " + indexes[1]);
            }
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
