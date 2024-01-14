package com.example.pokedex.services;

import com.example.pokedex.models.DataSource;
import com.example.pokedex.models.PokemonDescripted;

import java.sql.*;

/**
 * SQLData class implements the CreateData interface and provides methods to fetch Pokemon data
 * from a SQLite database using JDBC.
 */
public class SQLData implements CreateData {

    private final String url;

    private ResultSet resultSet;

    /**
     * Constructs an SQLData object with the default SQLite database URL.
     */
    public SQLData() {
        this.url = "jdbc:sqlite:pokemondatabase.sqlite";
    }

    /**
     * Constructs an SQLData object with a custom path for the SQLite database.
     *
     * @param path The custom path for the SQLite database.
     */
    public SQLData(String path) {
        this.url = "jdbc:sqlite:" + path;
        System.out.println(this.url);
    }

    /**
     * Fetches Pokémon data from the SQLite database based on the provided ID.
     *
     * @param id The ID of the Pokémon to fetch.
     */
    @Override
    public void getData(Long id) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement("SELECT id, name, height, weight, description FROM pokemons WHERE id = ?");
            stmt.setInt(1, id.intValue());
            resultSet = stmt.executeQuery();
            resultSet.next();
            System.out.println(resultSet);
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    /**
     * Creates a PokemonDescripted object based on the fetched data.
     *
     * @return A PokemonDescripted object representing the fetched data.
     */
    @Override
    public PokemonDescripted createPokemon() {
        try {
            return new PokemonDescripted(resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getLong("height"),
                    resultSet.getLong("weight"),
                    resultSet.getString("description"),
                    DataSource.LOCAL_DATABASE);
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return null;
        }
    }
}
