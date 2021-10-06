package PokeemonTrainer_06;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      Map<String,Trainer> trainers = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while(!line.equals("Tournament")){
            String [] info = line.split("\\s+");
            String nameTr =info[0];
            String pokemonN = info[1];
            String element = info[2];
            int health = Integer.parseInt(info[3]);
            Pokemon pokemon = new Pokemon(pokemonN,element,health);
            if(!trainers.containsKey(nameTr)) {
                Trainer trainer = new Trainer(nameTr, 0, new ArrayList<>());
                trainer.getPokemons().add(pokemon);
                trainers.put(nameTr,trainer);
            } else{
               trainers.get(nameTr).getPokemons().add(pokemon);
            }
            line = scanner.nextLine();
        }
       String element = scanner.nextLine();
        while(!element.equals("End")){
            for (Trainer value : trainers.values()) {
                int howManyPokemonsContains = findOut(value.getPokemons(),element);
                if(howManyPokemonsContains > 0){
                   value.setBadges(value.getBadges()+1);
                } else{
                    List<Pokemon> shrink = reduceHealth(value.getPokemons());
                    value.setPokemons(shrink);
                }
            }
            element = scanner.nextLine();
        }
        trainers.values().stream()
                .sorted((e1,e2) -> Integer.compare(e2.getBadges(),e1.getBadges()))
                .forEach(System.out::println);
    }

    private static List<Pokemon> reduceHealth(List<Pokemon> pokemons) {
        List<Pokemon> toRemove = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            int health = pokemon.getHealth();
            if(health - 10 > 0){
                pokemon.setHealth(health -10);
            } else{
               toRemove.add(pokemon);
            }
        }
        pokemons.removeAll(toRemove);
        return pokemons;
    }

    private static int findOut(List<Pokemon> pokemons,String element) {
        int count = 0;
        for (Pokemon pokemon : pokemons) {
            if(pokemon.getElement().equals(element)){
                count +=1;
            }
        }
        return count;
    }


}
