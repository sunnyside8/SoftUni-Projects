import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CookingJourney_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = createMatrix(scanner, size);
        int[] startPosition = findPosition(matrix);
        int money = 0;
        boolean out = false;
        char symbol = ' ';
        while (true) {
            int currentRow = startPosition[0];
            int currentCol = startPosition[1];
            matrix[currentRow][currentCol] = '-';
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (currentRow -1 == -1) {
                        out = true;
                        break;
                    } else {
                        currentRow -= 1;
                    }
                    break;
                case "down":
                    if (currentRow + 1 == size) {
                        out = true;
                        break;
                    } else {
                        currentRow += 1;
                    }
                    break;
                case "right":
                    if (currentCol + 1 == size) {
                        out = true;
                        break;
                    } else {
                        currentCol += 1;
                    }
                    break;
                case "left":
                    if (currentCol-1 == -1) {
                        out = true;
                        break;
                    } else {
                        currentCol -= 1;
                    }
                    break;
            }

            symbol = matrix[currentRow][currentCol];
            matrix[currentRow][currentCol] = '-';
            if (symbol == 'P') {
                int[] otherPillar = findOtherPillar(matrix, size, currentRow, currentCol);
                currentRow = otherPillar[0];
                currentCol = otherPillar[1];
            } else if (Character.isDigit(symbol)) {
                int sum = Integer.parseInt(String.valueOf(symbol));
                money += sum;
            }
            if (out) {
                break;
            }
            matrix[currentRow][currentCol] = 'S';
            if (money >= 50) {
                break;
            }
            startPosition[0] = currentRow;
            startPosition[1] = currentCol;
        }


        if (out) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", money);
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

    private static int[] findOtherPillar(char[][] matrix, int size, int currentRow, int currentCol) {
        int[] position = new int[2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char current = matrix[i][j];
                if (current == 'P' && i != currentRow && j != currentCol) {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        return position;
    }

    private static List<int[]> findPillarCordinates(char[][] matrix) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char current = matrix[i][j];
                if (current == 'P') {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;
    }

    private static int[] findPosition(char[][] matrix) {
        int[] position = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                char currentSymbol = matrix[i][j];
                if (currentSymbol == 'S') {
                    position[0] = i;
                    position[1] = j;
                    break;
                }
            }
        }
        return position;
    }

    private static char[][] createMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }
}