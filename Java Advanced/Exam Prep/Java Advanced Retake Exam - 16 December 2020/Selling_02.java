import java.util.Scanner;

public class Selling_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = readMatrix(size, scanner);
        int[] currentPosition = findPosition(matrix);
        char current = ' ';
        boolean out = false;
        int sum = 0;
        while (true) {
            String command = scanner.nextLine();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];
            matrix[currentRow][currentCol] = '-';
            switch (command) {
                case "right":
                    if (currentCol == size - 1) {
                        out = true;
                        break;
                    } else {
                        currentCol += 1;
                    }
                    break;
                case "down":
                    if (currentRow == size - 1) {
                        out = true;
                        break;
                    } else {
                        currentRow += 1;
                    }
                    break;
                case "left":
                    if (currentCol == 0) {
                        out = true;
                        break;
                    } else {
                        currentCol -= 1;
                    }
                    break;
                case "up":
                    if (currentRow == 0) {
                        out = true;
                        break;
                    } else {
                        currentRow -= 1;
                    }
                    break;
            }
            if(out){
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
            current = matrix[currentRow][currentCol];

            if (current == 'O') {
                matrix[currentRow][currentCol] = '-';
                int[] pillar = findOtherPillar(matrix,currentRow,currentCol);
                currentRow = pillar[0];
                currentCol = pillar[1];
            } else if(Character.isDigit(current)){
                sum+=Integer.parseInt(String.valueOf(current));
            }

            matrix[currentRow][currentCol] = 'S';
            if(sum >= 50){
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
            currentPosition[0]=currentRow;
            currentPosition[1] = currentCol;
        }
        System.out.printf("Money: %d%n",sum);
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

    private static int[] findOtherPillar(char[][] matrix, int currentRow, int currentCol) {
        int [] other = new int [2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if(current == 'O' && i != currentRow && j != currentCol){
                    other[0] = i;
                    other[1] = j;
                    break;
                }
            }
        }
        return other;
    }

    private static int[] findPosition(char[][] matrix) {
        int[] position = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if (current == 'S') {
                    position[0] = i;
                    position[1] = j;
                    break;
                }
            }
        }
        return position;
    }

    private static char[][] readMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }
}
