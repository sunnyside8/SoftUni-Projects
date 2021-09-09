package Preperation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int desiredDegrees = findDegrees(scanner);
        String word = scanner.nextLine();
        List<String> words =getWords(scanner, word);
        int lengthOfLongestWord = getLength(words);

        char [] [] matrix =  fillMatrix(words,lengthOfLongestWord);

        for (int i = 0; i < desiredDegrees/90; i++) {
            char [][] rotated90 = rotate90Degrees(matrix, matrix.length, matrix[0].length);
            matrix= rotated90;
        }
        printMatrix(matrix);


    }
    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static char [][] rotate90Degrees(char[][] matrix,int size,int lenght) {
        char[][] newMatrix = new char[lenght][size];
        for (int cols = 0; cols < lenght; cols++) {
            char [] newLine= new char[size];
            for (int i = 0;  i < size ; i++) {
                newLine[i] = matrix[i][cols];
            }
            newMatrix[cols] = reverse(newLine);
        }

        return newMatrix;

    }

    private static char[] reverse(char[] newLine) {
        char[] reversed= new char[newLine.length];
        int j = 0;
        for (int i = newLine.length-1; i >=0 ; i--) {
            reversed[j++] = newLine[i];
        }
        return reversed;
    }

    private static char[][] fillMatrix(List<String> words,int lengthOfLongestWord) {
        char[][] matrix = new char[words.size()][lengthOfLongestWord];
        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            char[] letters = currentWord.toCharArray();
            for (int j = 0; j < currentWord.length(); j++) {
                matrix[i][j] = letters[j];
            }
            if(currentWord.length() < matrix[i].length) {
                for (int j = currentWord.length(); j < matrix[i].length; j++) {
                    matrix[i][j] = ' ';
                }
            }
        }
        return matrix;
    }

    private static int getLength(List<String> words) {
        String longestWord = "";
        for (String word:words) {
            if (longestWord.length() < word.length()){
                longestWord = word;
            }
        }
        return longestWord.length();
    }


    private static List<String> getWords(Scanner scanner, String word) {
        List<String> words = new ArrayList<>();
        while(!word.equals("END")){
            words.add(word);
            word = scanner.nextLine();
        }
        return words;
    }

    private static int findDegrees(Scanner scanner) {
        String input = scanner.nextLine();
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int desiredDegrees = 0;
        if (matcher.find()){
            desiredDegrees = Integer.parseInt(matcher.group());
        }
        return desiredDegrees;
    }
}
