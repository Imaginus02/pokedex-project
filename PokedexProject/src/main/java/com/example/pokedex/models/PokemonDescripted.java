package com.example.pokedex.models;

/**
 * PokemonDescripted class extends the Pokémon class and includes additional attributes such as
 * a description and the data source from which the Pokémon information was retrieved.
 */
public class PokemonDescripted extends Pokemon {

    private final String description;
    private final DataSource dataSource;

    /**
     * Gets the description of the Pokémon.
     *
     * @return The description of the Pokémon.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the data source from which the Pokémon information was retrieved.
     *
     * @return The data source of the Pokémon information.
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * Constructs a PokemonDescripted object with the specified ID, name, size, weight,
     * description, and data source.
     *
     * @param id          The unique identifier of the Pokémon.
     * @param name        The name of the Pokémon.
     * @param size        The size or height of the Pokémon.
     * @param weight      The weight of the Pokémon.
     * @param description A description of the Pokémon.
     * @param dataSource  The data source from which the Pokémon information was retrieved.
     */
    public PokemonDescripted(Long id, String name, Long size, Long weight, String description, DataSource dataSource) {
        super(id, name, size, weight);
        this.description = description;
        this.dataSource = dataSource;

    }
}
