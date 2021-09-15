import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque <String> playingChildren = new ArrayDeque<>();
        String [] children = scanner.nextLine().split("\\s+");
        for (String child : children) {
            playingChildren.offer(child);
        }
        int n = Integer.parseInt(scanner.nextLine());
        while(playingChildren.size() > 1){
            for (int i = 0; i < n; i++) {
                if(i == n -1 ){
                    String removed = playingChildren.poll();
                    System.out.printf("Removed %s%n",removed);
                    continue;
                }
                playingChildren.offer(playingChildren.poll());
            }
        }
        System.out.println("Last is " + playingChildren.poll());
    }
}
