package com.example.pokedex.services;

import com.example.pokedex.models.Pokemon;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * HTTPData class implements the CreateData interface and provides methods to fetch Pokémon data
 * from the PokeAPI using HTTP requests.
 * The class uses Apache HttpClient to make HTTP requests and the JSONParser to parse the JSON response.
 */
public class HTTPData implements CreateData {

    private final CloseableHttpClient httpClient;

    private JSONObject finalObject;

    /**
     * Constructs an HTTPData object with a CloseableHttpClient for making HTTP requests.
     */
    public HTTPData() {
        this.httpClient = HttpClientBuilder.create().build();
    }

    /**
     * Fetches Pokémon data from the PokeAPI based on the provided ID.
     *
     * @param id The ID of the Pokémon to fetch.
     */
    @Override
    public void getData(Long id) {
        HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + id.toString());
        JSONParser parser = new JSONParser();
        request.addHeader("content-type", "application/json");
        String jsonResponse = "";
        try {
            HttpResponse response = this.httpClient.execute(request);
            jsonResponse = EntityUtils.toString(response.getEntity(), "UTF-8");
            Object resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                this.finalObject = (JSONObject) resultObject;
            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
        }
    }

    /**
     * Creates a Pokémon object based on the fetched data.
     *
     * @return A Pokémon object representing the fetched data.
     */
    @Override
    public Pokemon createPokemon() {
        return new Pokemon((Long) this.finalObject.get("id"),
                (String) this.finalObject.get("name"),
                (Long) this.finalObject.get("height"),
                (Long) this.finalObject.get("weight"));
    }
}
