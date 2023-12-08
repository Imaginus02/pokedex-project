package com.example.pokedex.services;

import com.example.pokedex.models.Pokemon;

public interface CreateData {

    public void getData(Long id);

    public Pokemon createPokemon();
}
