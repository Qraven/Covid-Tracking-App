package com.qrav.Covid.App;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class PrivateKey {

    private final String PRIVATE_KEY = "0fab9d344bmsh9b31eff68954e63p1dc65bjsn5a4a922a3bd6";

    public String getPRIVATEKEY() {
        return PRIVATE_KEY;
    }

    public HttpResponse<JsonNode> generateJsonResponse(String link) throws UnirestException {
        com.mashape.unirest.http.HttpResponse<JsonNode> jsonResponse = Unirest.get("https://covid-193.p.rapidapi.com/statistics?country=all")
                .header("x-rapidapi-host", "covid-193.p.rapidapi.com")
                .header("x-rapidapi-key", getPRIVATEKEY())
                .asJson();

        return jsonResponse;
    }
}
