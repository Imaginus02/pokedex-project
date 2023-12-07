package com.example.pokedex.models;

public class Pokemon {

    private final Long id;
    private final DataSource dataSource;

    private final String name;

    private final Long weight;

    private final Long size;

    private final String description;

    public Long getId() {
        return id;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public String getName() {
        return name;
    }

    public Long getSize() {
        return size;
    }

    public Long getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public Pokemon(Long id, String name, Long size, Long weight, String description, DataSource dataSource) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.description = description;
        this.dataSource = dataSource;
    }
}
