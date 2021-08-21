import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates_03_ObjectSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, City> cities = new TreeMap<>();
        String scan = scanner.nextLine();
        while (!scan.equals("Sail")) {
            String[] info = scan.split("\\|\\|");
            String city = info[0];
            int population = Integer.parseInt(info[1]);
            int gold = Integer.parseInt(info[2]);
            if (!cities.containsKey(city)) {
                City newCity = new City(population, gold);
                cities.put(city, newCity);
            } else {
                int currentGOLD = cities.get(city).getGold();
                int currentPEOPLE = cities.get(city).getPopulation();
                currentGOLD+=gold;
                currentPEOPLE+=population;
                cities.get(city).setGold(currentGOLD);
                cities.get(city).setPopulation(currentPEOPLE);
            }
            scan = scanner.nextLine();
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] line = command.split("=>");
            switch (line[0]) {
                case "Plunder":
                    int killedPeople = Integer.parseInt(line[2]);
                    int goldTaken = Integer.parseInt(line[3]);
                    int currentGold = cities.get(line[1]).getGold();
                    int currentPeople = cities.get(line[1]).getPopulation();
                    currentGold -= goldTaken;
                    currentPeople -= killedPeople;
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", line[1], goldTaken, killedPeople);
                    if (currentGold <= 0 || currentPeople <= 0) {
                        System.out.printf("%s has been wiped off the map!%n", line[1]);
                        cities.remove(line[1]);
                    } else {
                        cities.get(line[1]).setGold(currentGold);
                        cities.get(line[1]).setPopulation(currentPeople);
                    }
                    break;
                case "Prosper":
                    int givenGold = Integer.parseInt(line[2]);
                    if (givenGold <= 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int currentG = cities.get(line[1]).getGold();
                        currentG += givenGold;
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", givenGold, line[1], currentG);
                        cities.get(line[1]).setGold(currentG);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.entrySet().stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue().getGold(), e1.getValue().getGold()))
                    .forEach(entry -> {
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue().getPopulation(), entry.getValue().getGold());
                    });
        }
    }

    private static class City {
        //private String name;
        private int population;
        private int gold;


        public City(int population, int gold) {
            this.population = population;
            this.gold = gold;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }
    }
}
