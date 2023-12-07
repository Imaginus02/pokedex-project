package com.example.pokedex.services;

import com.example.pokedex.models.DataSource;
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

public class HTTPData implements CreateData {

    private final CloseableHttpClient httpClient;
    private final HttpGet request;
    private HttpResponse response;

    private final JSONParser parser;
    private Object resultObject;
    private JSONObject finalObject;

    public HTTPData() {
        this.httpClient = HttpClientBuilder.create().build();
        this.request = new HttpGet("https://pokeapi.co/api/v2/pokemon/1");
        this.parser = new JSONParser();
        request.addHeader("content-type", "application/json");
    }

    @Override
    public void getData() {
        String jsonResponse = "";
        try {
            response = this.httpClient.execute(request);
            jsonResponse = EntityUtils.toString(this.response.getEntity(), "UTF-8");
            this.resultObject = parser.parse(jsonResponse);
            if (this.resultObject instanceof JSONObject) {
                this.finalObject = (JSONObject) this.resultObject;
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

    @Override
    public Pokemon createPokemon() {
        return new Pokemon((Long) this.finalObject.get("id"),
                (String) this.finalObject.get("name"),
                (Long) this.finalObject.get("size"),
                (Long) this.finalObject.get("weight"),
                (String) this.finalObject.get("description"),
                DataSource.WEB_API);
    }
}
