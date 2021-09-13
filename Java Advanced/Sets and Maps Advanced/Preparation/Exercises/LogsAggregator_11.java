package Preparation;

import java.util.*;

public class LogsAggregator_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, userData> users = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = scanner.nextLine().split("\\s+");
            String user = tokens[1];
            String ip = tokens[0];
            int duration = Integer.parseInt(tokens[2]);
            if (!users.containsKey(user)){
                users.put(user,new userData(duration,new TreeSet<>()));
            } else{
                int time = users.get(user).getTime() + duration;
                users.get(user).setTime(time);

            }
            users.get(user).getIps().add(ip);
        }
        for (var entry : users.entrySet()) {
            System.out.printf("%s: %d [",entry.getKey(),entry.getValue().getTime());
            int count = 0;
            for (String ip : entry.getValue().getIps()) {
                System.out.printf("%s",ip);
                if(count++ != entry.getValue().getIps().size() -1){
                    System.out.print(", ");
                } else {
                    System.out.println("]");
                }
            }
        }




    }
     static class userData{
        private int time;
        private Set<String> ips;

        public userData(int time,Set<String> ips){
            this.time = time;
            this.ips = ips;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public Set<String> getIps() {
            return ips;
        }

        public void setIps(Set<String> ips) {
            this.ips = ips;
        }
    }
}
