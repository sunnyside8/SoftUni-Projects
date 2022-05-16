package RecursionAndCombinatorialProblems_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NestedLoopsToRecursion_02 {

    public static int [] array;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        array =  new int[n];
        permute(0);
    }

    private static void permute(int index) {
        if(index == array.length){
            print(array);
        } else{
            for (int i = 1; i <= array.length; i++) {
                array[index] = i;
                permute(index+1);
            }
        }
    }


    private static void print(int[] elements) {
        //System.out.println(String.join(" ", elements));
        Arrays.stream(elements).forEach(e-> System.out.print(e + " "));
        System.out.println();

    }
}
