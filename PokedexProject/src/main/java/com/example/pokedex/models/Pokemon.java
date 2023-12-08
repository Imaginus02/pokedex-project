package com.example.pokedex.models;

public class Pokemon {

    private final Long id;

    private final String name;

    private final Long weight;

    private final Long size;

    public Long getId() {
        return id;
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

    public Pokemon(Long id, String name, Long size, Long weight) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.weight = weight;
    }
}
