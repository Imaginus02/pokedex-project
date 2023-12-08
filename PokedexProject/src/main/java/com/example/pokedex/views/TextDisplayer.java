package com.example.pokedex.views;

import com.example.pokedex.models.DataSource;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonDescripted;

public class TextDisplayer implements Displayer {
    public TextDisplayer() {
    }

    String output = "";

    @Override
    public void generateOutput(Pokemon pokemon) {
        output += "=============================\n";
        output += "Pokémon # " + pokemon.getId().toString() + "\n";
        output += "Nom : " + pokemon.getName() + "\n";
        output += "Taille : " + pokemon.getSize() + "\n";
        output += "Poid : " + pokemon.getWeight() + "\n";
        if (pokemon instanceof PokemonDescripted) {
            if (((PokemonDescripted) pokemon).getDataSource() == DataSource.LOCAL_DATABASE)
                output += "Description : " + ((PokemonDescripted) pokemon).getDescription() + "\n";
        }
        output += "=============================\n";
    }

    public void output() {
        System.out.println(output);
    }
}
