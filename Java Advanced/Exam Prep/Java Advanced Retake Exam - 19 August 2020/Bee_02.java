import java.util.Scanner;

public class Bee_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char [][] matrix = fillMatrix(size,scanner);
        int pollinatedFlower = 0;
        int [] position = findPosition(matrix);
        char current = ' ';
        boolean out = false;
        String command = scanner.nextLine();
        while(!command.equals("End")){
            int currentRow = position[0];
            int currentCol = position[1];
            matrix[currentRow][currentCol] = '.';
            switch (command){
                case"up":
                    if(currentRow == 0){
                        out = true;
                        break;
                    } else{
                        currentRow -=1;
                    }
                    break;
                case"down":
                    if (currentRow == size-1){
                        out = true;
                        break;
                    } else{
                        currentRow +=1;
                    }
                    break;
                case"right":
                    if (currentCol == size -1){
                        out = true;
                        break;
                    } else{
                        currentCol +=1;
                    }
                    break;
                case"left":
                    if(currentCol == 0){
                        out = true;
                        break;
                    } else{
                        currentCol -=1;
                    }
                    break;
            }
            if(out){
                break;
            }
            current = matrix[currentRow][currentCol];
            if(current == 'O') {
                matrix[currentRow][currentCol] = '.';
                position[0] = currentRow;
                position[1] = currentCol;
                continue;
            }

            if (current == 'f'){
                pollinatedFlower +=1;
            }

            matrix[currentRow][currentCol] = 'B';
            position[0] = currentRow;
            position[1] = currentCol;
            command = scanner.nextLine();
        }
        if (out){
            System.out.println("The bee got lost!");
        }
        if(pollinatedFlower >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",pollinatedFlower);
        } else{
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",5 - pollinatedFlower);
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

    private static int[] findPosition(char[][] matrix) {
        int[] pos = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if(current == 'B'){
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
            }
        }
        return pos;
    }

    private static char[][] fillMatrix(int size, Scanner scanner) {
        char [][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            char [] line = scanner.nextLine().toCharArray();
            matrix[i] = line;
        }
        return matrix;
    }
}
