import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guest = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String command = scanner.nextLine();
        BiFunction<List<String>,String,List<String>> doubleStart = ((list,string) ->{
            List<String> toAdd = new ArrayList<>();
            for (String s : list) {
                if(s.startsWith(string)){
                    toAdd.add(s);
                }
            }
            list.addAll(toAdd);
            return list;
        });
        BiFunction<List<String>,String,List<String>> doubleEndsWith = ((list,string) ->{
            List<String> toAdd = new ArrayList<>();
            for (String s : list) {
                if(s.endsWith(string)){
                    toAdd.add(s);
                }
            }
            list.addAll(toAdd);
            return list;
        });
        BiFunction<List<String>,Integer,List<String>> doubleLength = ((list,integer) ->{
            List<String> toAdd = new ArrayList<>();
            for (String s : list) {
                if(s.length() == integer){
                   toAdd.add(s);
                }
            }
            list.addAll(toAdd);
            return list;
        });
        BiFunction<List<String>,String,List<String>> removeStartsWith = ((list,string) ->{
            list.removeIf(s -> s.startsWith(string));
            return list;
        });
        BiFunction<List<String>,String,List<String>> removeEndsWith = ((list,string) ->{
            list.removeIf(s -> s.endsWith(string));
            return list;
        });
        BiFunction<List<String>,Integer,List<String>> removeLength = ((list,integer) ->{
            list.removeIf(s -> s.length() == integer);
            return list;
        });

        while(!command.equals("Party!")){
            String [] tokens =command.split("\\s+");
            if(tokens[0].equals("Double")){
                if(tokens[1].equals("StartsWith")){
                    doubleStart.apply(guest,tokens[2]);
                } else if (tokens[1].equals("EndsWith")){
                    doubleEndsWith.apply(guest,tokens[2]);
                } else {
                    doubleLength.apply(guest,Integer.parseInt(tokens[2]));
                }
            } else{
                if(tokens[1].equals("StartsWith")){
                    removeStartsWith.apply(guest,tokens[2]);
                } else if (tokens[1].equals("EndsWith")){
                    removeEndsWith.apply(guest,tokens[2]);
                } else{
                    removeLength.apply(guest,Integer.parseInt(tokens[2]));
                }
            }
            command = scanner.nextLine();
        }
        if(guest.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else{
            Collections.sort(guest);
            System.out.println(String.join(", ",guest) + " are going to the party!");
        }
    }
}
