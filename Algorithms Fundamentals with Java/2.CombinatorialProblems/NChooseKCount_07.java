package CombinatorialProblems_02;

import java.util.Scanner;

public class NChooseKCount_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        int binon = binon(n,k);
        System.out.println(binon);

    }

    private static int binon(int n, int k) {
        if(k > n){
            return 0;
        }

        if(k == 0 || k == n){
            return 1;
        }

        return binon(n-1,k-1) + binon(n-1,k);
    }
}
