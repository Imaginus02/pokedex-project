package com.example.pokedex.models;

public class PokemonDescripted extends Pokemon{

    private final String description;
    private final DataSource dataSource;


    public String getDescription() {
        return description;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public PokemonDescripted(Long id, String name, Long size, Long weight, String description, DataSource dataSource) {
        super(id, name, size, weight);
        this.description = description;
        this.dataSource = dataSource;

    }
}
