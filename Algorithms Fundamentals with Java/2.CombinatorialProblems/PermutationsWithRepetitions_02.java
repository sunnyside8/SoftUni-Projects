package CombinatorialProblems_02;

import java.util.HashSet;
import java.util.Scanner;

public class PermutationsWithRepetitions_02 {
    static String [] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arr = scanner.nextLine().split(" ");
        
        permute(0);
    }

    private static void permute(int index) {
        if(index == arr.length){
            print(arr);
            return;
        }
        permute(index+1);
        HashSet<String> swapped = new HashSet<>();
        swapped.add(arr[index]);
        for (int i = index+1; i < arr.length; i++) {
            if(!swapped.contains(arr[i])) {
                swap(arr, index, i);
                permute(index + 1);
                swap(arr, index, i);
                swapped.add(arr[i]);
            }
        }
    }

    private static void swap(String[] arr,int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}
