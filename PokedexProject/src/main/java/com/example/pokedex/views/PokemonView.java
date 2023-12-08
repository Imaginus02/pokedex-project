package com.example.pokedex.views;

import com.example.pokedex.models.DataSource;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonDescripted;
import com.example.pokedex.utilities.MultipleFormatGenerator;

public class PokemonView implements MultipleFormatGenerator {

    private final Pokemon pokemon;

    public PokemonView(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String generateHumanReadableText() {
        String output = "";
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
        return output;
    }

    public String generateCSV() {
        String output = "Id;Name;Height;Weight";
        if (pokemon instanceof PokemonDescripted) {
            if (((PokemonDescripted) pokemon).getDataSource() == DataSource.LOCAL_DATABASE)
                output += ";Description";
        }

        output += ";\n"
                + pokemon.getId().toString() + ";"
                + "\"" + pokemon.getName() + "\";"
                + pokemon.getSize() + ";"
                + pokemon.getWeight() + ";";
        if (pokemon instanceof PokemonDescripted) {
            if (((PokemonDescripted) pokemon).getDataSource() == DataSource.LOCAL_DATABASE)
                output += "\"" + ((PokemonDescripted) pokemon).getDescription() + "\"";
        }
        return output;
    }

    public String generateHTML() {
        /*
         *<h1>name</h1>
         *<ul>
         *<li>Id : id</li>
         *<li>Taille : height</li>
         *<li>Poids : weight</li>
         *<li>Description : description</li>
         *</ul>
         */
        String output = "<h1>" + pokemon.getName() + "</h1>\n"
                + "<ul>\n"
                + "<li>Id : " + pokemon.getId().toString() + "</li>\n"
                + "<li>Taille : " + pokemon.getSize() + "</li>\n"
                + "<li>Poids : " + pokemon.getWeight() + "</li>\n";
        if (pokemon instanceof PokemonDescripted) {
            if (((PokemonDescripted) pokemon).getDataSource() == DataSource.LOCAL_DATABASE)
                output += "<li>Description : " + ((PokemonDescripted) pokemon).getDescription() + "</li>\n";
        }
        output += "</ul>\n";
        return output;
    }
}
