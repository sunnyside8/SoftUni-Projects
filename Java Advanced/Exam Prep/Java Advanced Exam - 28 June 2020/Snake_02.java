import java.util.Scanner;

public class Snake_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char [][] matrix = createMatrix(n,scanner);
        int [] position = findPosition(matrix);
        int food = 0;
        boolean out = false;
        char current = ' ';
        while (true) {
            String command = scanner.nextLine();
            int currentRow = position[0];
            int currentCol = position[1];
            matrix[currentRow][currentCol] = '.';
            switch (command){
                case"left":
                    if(currentCol == 0){
                        out = true;
                        break;
                    } else{
                        currentCol-=1;
                    }
                    break;
                case"down":
                    if(currentRow == n-1){
                        out = true;
                    } else{
                        currentRow+=1;
                    }
                    break;
                case"up":
                    if(currentRow == 0){
                        out = true;
                        break;
                    } else{
                        currentRow -=1;
                    }
                    break;
                case"right":
                    if(currentCol == n-1){
                        out = true;
                    } else{
                        currentCol+=1;
                    }
                    break;
            }
            if(out){
                break;
            }
            current = matrix[currentRow][currentCol];
            if(current == 'B'){
                matrix[currentRow][currentCol] = '.';
                int [] otherB = findB(matrix);
                currentRow = otherB[0];
                currentCol = otherB[1];
            } else if(current=='*'){
                food +=1;
            }
            matrix[currentRow][currentCol] = 'S';
            if(food >= 10){
                break;
            }
            position[0] = currentRow;
            position[1] = currentCol;
        }
        if(out){
            System.out.println("Game over!");
        } else{
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n",food);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] findB(char[][] matrix) {
        int [] B = new int [2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if (current == 'B'){
                    B[0] =i;
                    B[1]=j;
                    break;
                }
            }
        }
        return B;
    }

    private static int[] findPosition(char[][] matrix) {
        int [] position = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current =matrix[i][j];
                if(current == 'S'){
                    position[0]=i;
                    position[1]=j;
                    break;
                }
            }
        }
        return position;
    }

    private static char[][] createMatrix(int n, Scanner scanner) {
        char [][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] =scanner.nextLine().toCharArray();
        }
        return matrix;
    }
}
