package Preparation;

import java.util.*;

public class HandsOfCards_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String[] inputCards = input.split(": ")[1].split(",\\s+");
            Set<String> cards = new HashSet<>(Arrays.asList(inputCards));
            players.putIfAbsent(name, new HashSet<>());
            Set<String> currentCards = players.get(name);
            currentCards.addAll(cards);
            players.put(name, currentCards);
            input = scanner.nextLine();
        }
        for (var entry : players.entrySet()) {
            int point = getCardPoints(entry.getValue());
            System.out.println(entry.getKey() + ": " + point);
        }
    }

    private static int getCardPoints(Set<String> value) {
        int sum = 0;
        Map<Character, Integer> pointsValues = getPointsValues();
        for (String card : value) {
            int points = 0;
            if (card.contains("10")) {
                char strength = card.charAt(2);
                points = 10 * pointsValues.get(strength);
                sum += points;
                continue;
            } else {
                char number = card.charAt(0);
                char strength = card.charAt(1);
                points = pointsValues.get(strength) * pointsValues.get(number);
            }
            sum += points;
        }
        return sum;
    }

    private static Map<Character, Integer> getPointsValues() {
        Map<Character, Integer> points = new HashMap<>();
        points.put('1', 1);
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        // points.put('10',10);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);
        return points;


    }
}
