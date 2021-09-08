package Preperation;

import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        String matrix [] [] = new String[rows][cols];
        fillMatrix(matrix,rows,cols,scanner);
         String command = scanner.nextLine();
         while(!command.equals("END")){
             if(!validateCommand(command,rows,cols)){
                 System.out.println("Invalid input!");
                 command = scanner.nextLine();
                 continue;
             } else{
                 String[] tokens = command.split("\\s+");
                 int rowFirst = Integer.parseInt(tokens[1]);
                 int colFirst = Integer.parseInt(tokens[2]);
                 int rowSecond = Integer.parseInt(tokens[3]);
                 int colSecond = Integer.parseInt(tokens[4]);
                 String element1= matrix[rowFirst][colFirst];
                 String element2=matrix[rowSecond][colSecond];
                 matrix[rowFirst][colFirst] = element2;
                 matrix[rowSecond][colSecond] = element1;
                 printMatrix(matrix,rows,cols);

             }
             command = scanner.nextLine();
         }
    }

    private static boolean validateCommand(String command,int rows,int cols) {
        String[] tokens = command.split("\\s+");
        String commandName = tokens[0];

        if(tokens.length != 5){
            return false;
        }
        if(!commandName.equals("swap")){
            return false;
        }


        int rowFirst = Integer.parseInt(tokens[1]);
        int colFirst = Integer.parseInt(tokens[2]);
        int rowSecond = Integer.parseInt(tokens[3]);
        int colSecond = Integer.parseInt(tokens[4]);

        if (rowFirst >= rows || colFirst >= cols || rowSecond >= rows || colSecond >= cols){
            return false;
        }
        if (rowFirst < 0 || colFirst <0 || rowSecond < 0|| colSecond < 0){
            return false;
        }

        return true;
    }

    private static void fillMatrix(String[][] matrix,int rows,int cols, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
                matrix[row]= scanner.nextLine().split("\\s+");
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

