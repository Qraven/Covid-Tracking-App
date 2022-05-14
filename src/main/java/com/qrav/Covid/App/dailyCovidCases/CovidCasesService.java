package com.qrav.Covid.App.dailyCovidCases;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.qrav.Covid.App.JsonNodeMapper;
import com.qrav.Covid.App.PrivateKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CovidCasesService {

    @Autowired
    private PrivateKey privateKey;

    @Autowired
    private JsonNodeMapper jsonNodeMapper;

    public String getCovidCases(String country) throws UnirestException {

        country = country.replace(' ', '-');

        String link = "https://covid-193.p.rapidapi.com/statistics?country=" +country;
        HttpResponse<JsonNode> jsonResponse= privateKey.generateJsonResponse(link);
        return jsonNodeMapper.convertJsonResponseResponseToString(jsonResponse);
    }
}
