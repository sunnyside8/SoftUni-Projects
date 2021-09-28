import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String [] commands = scanner.nextLine().split(",\\s+");
        char [][] matrix = createMatrix(size,scanner);
        int [] starPosition = findPosition(matrix);
        int countFoodPresent = findFoodCount(matrix);
        int currentFoodEaten = 0;
        char currentChar = ' ';
        boolean killedByE = false;
        for (String command : commands) {
            int currentRow = starPosition[0];
            int currentCol = starPosition[1];
            switch (command){
                case"up":
                    currentRow = goingUp(currentRow,size);
                    currentChar = matrix[currentRow][currentCol];
                    if(currentChar == 'e'){
                        killedByE = true;
                        break;
                    } else if(currentChar == 'f'){
                        currentFoodEaten++;
                    }
                    break;
                case"down":
                    currentRow = goingDown(currentRow,size);
                    currentChar = matrix[currentRow][currentCol];
                    if(currentChar == 'e'){
                        killedByE = true;
                        break;
                    } else if(currentChar == 'f'){
                        currentFoodEaten++;
                    }
                    break;
                case"right":
                    currentCol = goingRight(currentCol,size);
                    currentChar = matrix[currentRow][currentCol];
                    if(currentChar == 'e'){
                        killedByE = true;
                        break;
                    } else if(currentChar == 'f'){
                        currentFoodEaten++;
                    }
                    break;
                case"left":
                    currentCol = goingLeft(currentCol,size);
                    currentChar = matrix[currentRow][currentCol];
                    if(currentChar == 'e'){
                        killedByE = true;
                        break;
                    } else if(currentChar == 'f'){
                        currentFoodEaten++;
                    }
                    break;
            }
            if(killedByE){
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            if(currentFoodEaten == countFoodPresent){
                System.out.printf("You win! Final python length is %d",currentFoodEaten +1);
                return;
            }
            starPosition[0] = currentRow;
            starPosition[1] = currentCol;
        }
        System.out.printf("You lose! There is still %d food to be eaten.",countFoodPresent - currentFoodEaten);
    }

    private static int goingLeft(int currentCol, int size) {
        if(currentCol -1 == -1){
            return currentCol =size-1;
        } else{
            currentCol -=1;
            return currentCol;
        }
    }

    private static int goingDown(int currentRow, int size) {
        if(currentRow +1 == size){
            return currentRow = 0;
        } else{
            currentRow +=1;
            return currentRow;
        }
    }

    private static int goingRight(int currentCol, int size) {
        if(currentCol +1 == size){
            return currentCol = 0;
        } else{
            currentCol+=1;
            return currentCol;
        }
    }

    private static int goingUp(int currentRow,int size) {
        if (currentRow - 1 == -1) {
            return currentRow = size -1;
        } else{
            return currentRow-= 1;
        }
    }

    private static int findFoodCount(char[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if(current == 'f'){
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] findPosition(char[][] matrix) {
        int[] position = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char current = matrix[i][j];
                if(current == 's'){
                    position[0] = i;
                    position[1] =j;
                    break;
                }
            }
        }
        return position;
    }

    private static char[][] createMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][];
        for (int i = 0; i < size; i++) {
          String [] line=scanner.nextLine().split("\\s+");
          char[] lining = new char[size];
            for (int j = 0; j < line.length; j++) {
                lining[j] = line[j].charAt(0);
            }
            matrix[i] = lining;
        }
        return  matrix;
    }
}
