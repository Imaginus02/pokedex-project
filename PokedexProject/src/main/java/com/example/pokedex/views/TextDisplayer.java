package com.example.pokedex.views;

import com.example.pokedex.models.Pokemon;

public class TextDisplayer implements Displayer{
    public TextDisplayer() {}

    String output = "";

    @Override
    public void generateOutput(Pokemon pokemon) {
        output += "=============================\n";
        output += "Pokémon # "+pokemon.getId().toString()+"\n";
        output += "Nom : "+pokemon.getName()+"\n";
        output += "Taille : "+pokemon.getSize()+"\n";
        output += "Poid : "+pokemon.getWeight()+"\n";
        output += "=============================\n";
    }

    public void output() {
        System.out.println(output);
    }
}
