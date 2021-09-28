import java.util.Scanner;

public class FormulaOne_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(size, scanner);
        int[] playerCoordinates = findPlayerCoordinated(matrix);
        matrix[ playerCoordinates[0]][ playerCoordinates[1]] = '.';
        boolean playerHasFinished = false;
        for (int i = 0; i < commands; i++) {
            String command = scanner.nextLine();
            int playerRow = playerCoordinates[0];
            int playerCol = playerCoordinates[1];
            switch (command) {
                case "up":
                    playerRow = movingUp(size, playerRow);
                    char currentCharU = matrix[playerRow][playerCol];
                    if(currentCharU == 'B'){
                        playerRow = movingUp(size, playerRow);
                    } else if (currentCharU == 'T') {
                        playerRow = playerCoordinates[0];
                    } else if(currentCharU == 'F'){
                        matrix[playerRow][playerCol] = 'P';
                        playerHasFinished = true;
                        break;
                    }
                    break;
                case "down":
                    playerRow = movingDown(size, playerRow);
                    char currentCharD = matrix[playerRow][playerCol];
                    if (currentCharD == 'B') {
                        playerRow = movingDown(size, playerRow);
                    } else if (currentCharD == 'T') {
                        playerRow = playerCoordinates[0];
                    } else if (currentCharD == 'F') {
                        matrix[playerRow][playerCol] = 'P';
                        playerHasFinished = true;
                        break;
                    }
                    break;
                case "left":
                    playerCol = movingLeft (size,playerCol);
                    char currentCharL = matrix[playerRow][playerCol];
                    if(currentCharL == 'B'){
                        playerCol = movingLeft (size,playerCol);
                    } else if (currentCharL == 'T'){
                        playerCol = playerCoordinates[1];
                    } else if (currentCharL == 'F'){
                        matrix[playerRow][playerCol] = 'P';
                        playerHasFinished = true;
                        break;
                    }
                    break;
                case "right":
                    playerCol = movingRight (size,playerCol);
                    char currentCharR = matrix[playerRow][playerCol];
                    if (currentCharR == 'B') {
                        playerCol = movingRight (size,playerCol);
                    }else if (currentCharR == 'T') {
                        playerCol = playerCoordinates[1];
                    } else if (currentCharR == 'F') {
                        matrix[playerRow][playerCol] = 'P';
                        playerHasFinished = true;
                        break;
                    }
                    break;
            }
            playerCoordinates[0] = playerRow;
            playerCoordinates[1] = playerCol;
            if (playerHasFinished) {
                break;
            }
        }
        if(playerHasFinished){
            System.out.println("Well done, the player won first place!");
        } else{
            matrix[playerCoordinates[0]][ playerCoordinates[1]] = 'P';
            System.out.println("Oh no, the player got lost on the track!");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int movingLeft(int size, int playerCol) {
        if (playerCol - 1 == -1){
             playerCol = size-1;
            return playerCol;
        } else {
            return playerCol -=1;
        }
    }

    private static int movingUp(int size, int playerRow) {
        if (playerRow -1 == -1){
            playerRow = size -1;
            return playerRow;
        } else{
            return playerRow -=1;
        }
    }

    private static int movingRight(int size, int playerCol) {
        if(playerCol + 1 == size){
           playerCol =0;
            return playerCol;
        } else{
            return playerCol+=1;
        }
    }

    private static int movingDown(int size, int playerRow) {
        if (playerRow + 1 == size) {
            playerRow = 0;
            return playerRow;
        } else {
            return playerRow = playerRow + 1;
        }
    }

    private static int[] findPlayerCoordinated(char[][] matrix) {
        int[] player = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char current = matrix[i][j];
                if (current == 'P') {
                    player[0] = i;
                    player[1] = j;
                }
            }
        }
        return player;
    }

    private static char[][] fillMatrix(int size, Scanner scanner) {
        char[][] fillMatrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            char[] lining = line.toCharArray();
            fillMatrix[i] = lining;
        }
        return fillMatrix;
    }
}
