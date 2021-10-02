import java.util.Scanner;

public class Bomb_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String [] commands = scanner.nextLine().split(",");
        char [][] matrix = readMatrix(size,scanner);
       int presentBombs = findBombs(matrix);
       int [] startPosition = findStart(matrix);
       int deactivatedBombs = 0;
       char currentChar = ' ';
        for (String command : commands) {
            int currentRow = startPosition[0];
            int currentCol = startPosition[1];
            switch (command){
                case"up":
                   if (currentRow != 0 ){
                       currentRow -= 1;
                   }
                break;
                case"right":
                    if(currentCol != size - 1){
                        currentCol +=1;
                    }
                    break;
                case"down":
                    if(currentRow != size -1){
                        currentRow +=1;
                    }
                    break;
                case"left":
                    if(currentCol != 0){
                        currentCol -=1;
                    }
                    break;
            }
            currentChar = matrix[currentRow][currentCol];
            if(currentChar == 'B'){
                deactivatedBombs +=1;
                matrix[currentRow][currentCol] = '+';
                System.out.println("You found a bomb!");
                if(deactivatedBombs == presentBombs){
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (currentChar == 'e'){
                System.out.printf("END! %d bombs left on the field",presentBombs - deactivatedBombs);
                return;
            }
            startPosition[0] = currentRow;
            startPosition[1] = currentCol;
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",presentBombs - deactivatedBombs,startPosition[0],startPosition[1]);
    }

    private static int [] findStart(char[][] matrix) {
        int [] start = new int [2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if(current == 's'){
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }
        return start;
    }

    private static int findBombs(char[][] matrix) {
        int bombs = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if(current == 'B'){
                    bombs+=1;
                }
            }
        }
        return bombs;
    }

    private static char[][] readMatrix(int size,Scanner scanner) {
        char[][] matrix = new char[size][];
        for (int i = 0; i < size; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            char[] lining = new char[size];
            for (int j = 0; j < line.length; j++) {
                lining[j] = line[j].charAt(0);
            }
            matrix[i] = lining;
        }
        return matrix;
    }
}
