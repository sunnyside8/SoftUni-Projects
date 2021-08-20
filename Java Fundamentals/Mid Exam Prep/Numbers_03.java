import java.util.*;
import java.util.stream.Collectors;

public class Numbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> integers = Arrays.stream(input).map(e->Integer.parseInt(e)).collect(Collectors.toList());
        double sum = 0;
        for (int i = 0; i < integers.size(); i++) {
           double num = integers.get(i);
            sum+=num;
        }
        sum= sum / integers.size();
        List <Integer> great = new ArrayList<>();
        Collections.sort(integers);
        int count = 0;
        for (int i = integers.size() - 1; i >= 0 ; i--) {
            int num = integers.get(i);
            if (num > sum && count < 5){
                great.add(num);
                count++;
            }
        }
        if (count == 0){
            System.out.println("No");
        } else {
            System.out.println(great.toString().replace("[","")
                    .replace(", "," ")
                    .replace("]",""));
        }
    }
}
