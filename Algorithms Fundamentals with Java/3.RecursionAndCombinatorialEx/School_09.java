package Rec_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School_09 {
    public static String[] girlsElements;
    public static String[] girlsVariations;
    public static List<String> girlVar;

    public static String [] boysElements;
    public static String [] boysVariations;
    public static List<String> boyVar;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        girlsElements = scanner.nextLine().split(", ");
        girlsVariations = new String[3];
        girlVar = new ArrayList<>();

        boysElements = scanner.nextLine().split(", ");
        boysVariations = new String[2];
        boyVar = new ArrayList<>();

        girlCombinations(0, 0);

        boysCombinations(0,0);


        for (String g : girlVar) {
            for (String s : boyVar) {
                System.out.println(g + ", " + s);
            }

        }

    }

    private static void boysCombinations(int index, int start) {
        if(index == 2){
            boyVar.add(String.join(", ",boysVariations));
        } else{
            for (int i = start; i < boysElements.length; i++) {
                boysVariations[index] = boysElements[i];
                boysCombinations(index+1,i+1);
            }
        }
    }

    private static void girlCombinations(int index, int start) {
        if (index == 3) {
           girlVar.add(String.join(", ", girlsVariations));
        } else {
            for (int i = start; i < girlsElements.length; i++) {
                girlsVariations[index] = girlsElements[i];
                girlCombinations(index + 1, i + 1);
            }
        }
    }



}

