package com.example.pokedex.views;

import com.example.pokedex.models.Pokemon;

public interface Displayer {
    void generateOutput(Pokemon pokemon);

    void output();
}
