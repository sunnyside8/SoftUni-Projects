import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer,BankAccount> bankAccounts = new HashMap<>();
        String command = scanner.nextLine();
        while(!command.equals("End")){
            String [] tokens = command.split("\\s+");
            String output = null;
            if(tokens[0].equals("Create")){
                BankAccount account = new BankAccount();
                bankAccounts.put(account.getId(),account);
                output = "Account ID"+ account.getId() + " created";
            } else if(tokens[0].equals("Deposit")){
                int id = Integer.parseInt(tokens[1]);
               int amount = Integer.parseInt(tokens[2]);

                if(!bankAccounts.containsKey(id)){
                    output ="Account does not exist";
                } else {
                    bankAccounts.get(id).deposit(amount);
                    output = String.format("Deposited %d to ID%d",amount,id);
                }
            } else if(tokens[0].equals("SetInterest")){
                BankAccount.setInterestTate(Double.parseDouble(tokens[1]));

            } else {
                int id = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);

                if(!bankAccounts.containsKey(id)){
                    output ="Account does not exist";
                } else {
                    double interest = bankAccounts.get(id).getInterest(years);
                    output = String.format("%.2f",interest);
                }

            }
            if(output != null){
                System.out.println(output);
            }
            command = scanner.nextLine();
        }



    }
}
