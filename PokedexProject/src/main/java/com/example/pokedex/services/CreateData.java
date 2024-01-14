package com.example.pokedex.services;

import com.example.pokedex.models.Pokemon;

/**
 * CreateData interface defines methods for retrieving Pokémon data and creating Pokemon objects.
 */
public interface CreateData {

    /**
     * Retrieves Pokémon data based on the provided ID.
     *
     * @param id The ID of the Pokémon to retrieve data for.
     */
    public void getData(Long id);

    /**
     * Creates a Pokémon object based on the previously retrieved data.
     *
     * @return A Pokémon object representing the retrieved data.
     */
    public Pokemon createPokemon();
}
