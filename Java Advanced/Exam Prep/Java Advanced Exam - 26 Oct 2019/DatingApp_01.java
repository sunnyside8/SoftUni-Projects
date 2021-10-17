import java.util.ArrayDeque;
import java.util.Scanner;

public class DatingApp_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] maleString = scanner.nextLine().split("\\s+");
        String [] femaleString=scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> males= new ArrayDeque<>();//Стек
        for (String s : maleString) {
            males.push(Integer.parseInt(s));
        }
        ArrayDeque<Integer> females = new ArrayDeque<>();//опашка
        for (String s : femaleString) {
            females.offer(Integer.parseInt(s));
        }
        int matches = 0;
        while(females.size() >= 1 && males.size()>= 1){
            int male = males.peek();
            int female = females.peek();
            if(male <= 0 || female <= 0){
                if(male <= 0){
                    males.pop();
                }
                if(female <= 0){
                    females.poll();
                }
                continue;
            }
            if(male % 25 == 0 || female % 25 == 0 ) {
                if (male % 25 == 0) {
                    males.pop();
                    males.pop();
                }
                if(female % 25 == 0){
                    females.poll();
                    females.poll();
                }
                continue;
            }
            if(male == female){
                matches +=1;
                males.pop();
                females.poll();
            } else{
                females.poll();
                males.push(males.pop() -2);
            }
        }
        System.out.println("Matches: " + matches);
        if(males.isEmpty()){
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.print(String.join(", ",males.toString()).replaceAll("\\[","").replaceAll("\\]",""));
            System.out.println();
        }
        if(females.isEmpty()){
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.print(String.join(", ",females.toString()).replaceAll("\\[","").replaceAll("\\]",""));
            System.out.println();
        }

    }
}
