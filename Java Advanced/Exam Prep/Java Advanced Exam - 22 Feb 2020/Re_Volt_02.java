import java.util.Scanner;

public class Re_Volt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(size, scanner);
        int[] startPosition = findStart(matrix);
        char currentChar = ' ';
        boolean finished = false;
        for (int i = 0; i < countCommands; i++) {
            String command = scanner.nextLine();
            int currentRow = startPosition[0];
            int currentCol = startPosition[1];
            switch (command) {
                case "down":
                    currentRow = movingDown(currentRow, size);
                    currentChar = matrix[currentRow][currentCol];
                    if (currentChar == 'B') {
                        currentRow = movingDown(currentRow, size);
                    }
                    break;
                case "right":
                    currentCol = movingRight(currentCol, size);
                    currentChar = matrix[currentRow][currentCol];
                    if (currentChar == 'B') {
                        currentCol = movingRight(currentCol, size);
                    }
                    break;
                case "up":
                    currentRow = movingUp(currentRow,size);
                    currentChar = matrix[currentRow][currentCol];
                    if(currentChar == 'B'){
                        currentRow = movingUp(currentRow,size);
                    }
                    break;
                case "left":
                    currentCol = movingLeft(currentCol,size);
                    currentChar = matrix[currentRow][currentCol];
                    if(currentChar == 'B'){
                        currentCol = movingLeft(currentCol,size);
                    }
                    break;
            }
            currentChar = matrix[currentRow][currentCol];
            if (currentChar == 'T'){
                currentRow = startPosition[0];
                currentCol = startPosition[1];
            } else if (currentChar == 'F') {
                matrix[currentRow][currentCol] = 'f';
                finished = true;
                break;
            }
            startPosition [0] = currentRow;
            startPosition[1] = currentCol;
            if(finished){
                break;
            }
        }
        if(finished){
            System.out.println("Player won!");
        } else{
            matrix[startPosition [0]][startPosition[1]] = 'f';
            System.out.println("Player lost!");
        }
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

    private static int movingLeft(int currentCol, int size) {
        if(currentCol == 0){
            currentCol = size-1;
        } else{
            currentCol -=1;
        }
        return currentCol;
    }

    private static int movingUp(int currentRow, int size) {
        if(currentRow == 0){
            currentRow = size -1;
        } else{
           currentRow -=1;
        }
        return currentRow;
    }

    private static int movingRight(int currentCol, int size) {
        if (currentCol == size - 1) {
            return 0;
        } else {
            currentCol += 1;
            return currentCol;
        }
    }

    private static int movingDown(int currentRow, int size) {
        if (currentRow == size - 1) {
            return 0;
        } else {
            currentRow += 1;
            return currentRow;
        }

    }

    private static int[] findStart(char[][] matrix) {
        int[] pos = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if (current == 'f') {
                    matrix[i][j] = '-';
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
            }
        }
        return pos;
    }

    private static char[][] fillMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }
}
