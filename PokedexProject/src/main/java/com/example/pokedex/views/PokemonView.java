package com.example.pokedex.views;

import com.example.pokedex.models.DataSource;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.PokemonDescripted;
import com.example.pokedex.utilities.MultipleFormatGenerator;

/**
 * PokemonView class implements the MultipleFormatGenerator interface and provides methods to generate
 * human-readable text, CSV, and HTML representations of Pokémon information.
 */
public class PokemonView implements MultipleFormatGenerator {

    private final Pokemon pokemon;

    /**
     * Constructs a PokemonView object with the specified Pokémon.
     *
     * @param pokemon The Pokémon for which the view is created.
     */
    public PokemonView(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * Generates a human-readable text representation of the Pokémon.
     *
     * @return The human-readable text representation.
     */
    @Override
    public String generateHumanReadableText() {
        String output = "";
        output += "=============================\n";
        output += "Pokémon # " + pokemon.getId().toString() + "\n";
        output += "Nom : " + pokemon.getName() + "\n";
        output += "Taille : " + pokemon.getSize() + "\n";
        output += "Poids : " + pokemon.getWeight() + "\n";
        if (pokemon instanceof PokemonDescripted) {
            if (((PokemonDescripted) pokemon).getDataSource() == DataSource.LOCAL_DATABASE)
                output += "Description : " + ((PokemonDescripted) pokemon).getDescription() + "\n";
        }
        output += "=============================\n";
        return output;
    }

    /**
     * Generates a CSV representation of the Pokémon.
     *
     * @return The CSV representation.
     */
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

    /**
     * Generates an HTML representation of the Pokémon.
     *
     * @return The HTML representation.
     */
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
