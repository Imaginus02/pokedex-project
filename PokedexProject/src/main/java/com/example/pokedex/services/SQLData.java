package com.example.pokedex.services;

import com.example.pokedex.models.DataSource;
import com.example.pokedex.models.Pokemon;

import java.sql.*;

public class SQLData implements CreateData{

    private final String url;

    private ResultSet resultSet;

    /*
    * We are using the local database copied in the App folder
    */
    public SQLData() {
        this.url = "jdbc:sqlite:pokemondatabase.sqlite";
    }
    public SQLData(String path) {
        this.url = "jdbc:sqlite:"+path;
        System.out.println(this.url);
    }
    @Override
    public void getData(Long id) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
//            System.out.println("Connection to SQLite has been established.");
            PreparedStatement stmt = conn.prepareStatement("SELECT id, name, height, weight, description FROM pokemons WHERE id = ?");
            stmt.setInt(1,id.intValue());
            resultSet = stmt.executeQuery();
//            resultSet.next();
            System.out.println(resultSet);
        } catch (SQLException sqlException) {
//            System.out.println("\nError found :");
            System.out.println(sqlException.getMessage());
        }
    }

    @Override
    public Pokemon createPokemon() {
        try {
            return new Pokemon(resultSet.getLong("id"),
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
