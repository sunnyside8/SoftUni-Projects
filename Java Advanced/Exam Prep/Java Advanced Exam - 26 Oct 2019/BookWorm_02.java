import java.util.Scanner;

public class BookWorm_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int size = Integer.parseInt(scanner.nextLine());
        char [][] matrix = createMatrix(size,scanner);
        StringBuilder build = new StringBuilder(line);
        String command = scanner.nextLine();
        int [] startPosition = findStart(matrix);
        matrix[startPosition[0]][startPosition[1]] = '-';
        char current = ' ';
        while(!command.equals("end")){
            int currentRow= startPosition[0];
            int currentCol = startPosition[1];
            boolean punishment = false;
            switch (command){
                case"up":
                   if (currentRow != 0){
                       currentRow-=1;
                   }  else{
                       punishment = true;
                   }
                    break;
                case"right":
                    if(currentCol != size-1){
                        currentCol +=1;
                    } else{
                        punishment = true;
                    }

                    break;
                case"left":
                    if(currentCol != 0){
                        currentCol-=1;
                    } else{
                        punishment = true;
                    }
                    break;
                case"down":
                   if(currentRow  != size -1){
                        currentRow += 1;
                   } else{
                       punishment = true;
                   }
                   break;
            }
            startPosition[0] = currentRow;
            startPosition[1] = currentCol;
            if(punishment){
                build.deleteCharAt(build.length() -1);
            }
            current = matrix[currentRow][currentCol];
            if(Character.isAlphabetic(current)){
                build.append(current);
                matrix[currentRow][currentCol] = '-';
            }
            command = scanner.nextLine();
        }
        matrix[startPosition[0]][startPosition[1]] = 'P';
        System.out.println(build);
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


    private static int[] findStart(char[][] matrix) {
        int [] pos = new int [2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j]== 'P'){
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
            }
        }
        return pos;
    }

    private static char[][] createMatrix(int size, Scanner scanner) {
        char [][] matrix = new char[size][];
        for (int i = 0; i < size; i++) {
           char [] line = scanner.nextLine().toCharArray();
            matrix[i] = line;
         }
        return matrix;
    }
}
