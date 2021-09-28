import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Set;

public class OSPlanning_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tasksString = scanner.nextLine().split(",\\s+");
        String [] threadsString =scanner.nextLine().split("\\s+");
        int stoppingTask = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        for (String s : tasksString) {
            tasks.push(Integer.parseInt(s));
        }
        ArrayDeque <Integer> threads = new ArrayDeque<>();
        for (String s : threadsString) {
            threads.offer(Integer.parseInt(s));
        }
        while(true){
            int thread = threads.poll();
            int task = tasks.pop();
            if(task == stoppingTask){
                System.out.printf("Thread with value %d killed task %d%n",thread,task);
                threads.addFirst(thread);
                break;
            }
            if(thread < task){
                tasks.push(task);
            }
        }
        for (Integer thread : threads) {
            System.out.print(thread + " ");
        }
    }
}
