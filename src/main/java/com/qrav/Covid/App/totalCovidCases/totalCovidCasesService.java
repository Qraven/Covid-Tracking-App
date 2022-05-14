package com.qrav.Covid.App.totalCovidCases;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.qrav.Covid.App.JsonNodeMapper;
import com.qrav.Covid.App.PrivateKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class totalCovidCasesService {

    @Autowired
    private PrivateKey privateKey;

    @Autowired
    private JsonNodeMapper jsonNodeMapper;

    public String getTotalCovidCases() throws UnirestException {

        HttpResponse<JsonNode> jsonResponse = privateKey.generateJsonResponse("https://covid-193.p.rapidapi.com/statistics?country=all");
        return jsonNodeMapper.convertJsonResponseResponseToString(jsonResponse);
    }

}
