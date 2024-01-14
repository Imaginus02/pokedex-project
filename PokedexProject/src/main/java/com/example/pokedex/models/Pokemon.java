package com.example.pokedex.models;

/**
 * Pokémon class represents a Pokémon with its attributes such as ID, name, size, and weight.
 */
public class Pokemon {

    private final Long id;

    private final String name;

    private final Long weight;

    private final Long size;

    /**
     * Gets the unique identifier of the Pokémon.
     *
     * @return The ID of the Pokémon.
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the name of the Pokémon.
     *
     * @return The name of the Pokémon.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the size or height of the Pokémon.
     *
     * @return The size of the Pokémon.
     */
    public Long getSize() {
        return size;
    }

    /**
     * Gets the weight of the Pokémon.
     *
     * @return The weight of the Pokémon.
     */
    public Long getWeight() {
        return weight;
    }

    /**
     * Constructs a Pokémon object with the specified ID, name, size, and weight.
     *
     * @param id     The unique identifier of the Pokémon.
     * @param name   The name of the Pokémon.
     * @param size   The size or height of the Pokémon.
     * @param weight The weight of the Pokémon.
     */
    public Pokemon(Long id, String name, Long size, Long weight) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.weight = weight;
    }
}
