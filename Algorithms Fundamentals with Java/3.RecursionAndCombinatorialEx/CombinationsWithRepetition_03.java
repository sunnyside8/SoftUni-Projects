package RecursionAndCombinatorialProblems_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombinationsWithRepetition_03 {
    public static int [] array;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        array = new int[m];

        combinations(0,1);
    }

    private static void combinations(int index,int start) {
        if(index == array.length){
            print(array);
        } else{
            for (int i = start; i <= n; i++) {
                array[index] = i;
                combinations(index +1,i);
            }
        }
    }

    private static void print(int[] elements) {
        //System.out.println(String.join(" ", elements));
        Arrays.stream(elements).forEach(e-> System.out.print(e + " "));
        System.out.println();

    }
}
