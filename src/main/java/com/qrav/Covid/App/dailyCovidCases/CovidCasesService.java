package com.qrav.Covid.App.dailyCovidCases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.qrav.Covid.App.JsonNodeMapper;
import com.qrav.Covid.App.PrivateKey;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

@Service
public class CovidCasesService {

    @Autowired
    PrivateKey privateKey;

    public String getCovidCases(String country) throws UnirestException {

        country = country.replace(' ', '-');

        HttpResponse<JsonNode> response = Unirest.get("https://covid-193.p.rapidapi.com/statistics?country="+country)
                .header("x-rapidapi-host", "covid-193.p.rapidapi.com")
                .header("x-rapidapi-key", privateKey.getPRIVATEKEY())
                .asJson();

        JSONArray jsonArray = response.getBody().getArray();
        System.out.println(jsonArray);
        String active = "";

        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject jOBJ = jsonArray.getJSONObject(i);
            JSONArray jArray1 = jOBJ.getJSONArray("response");

            for (int j = 0; j < jArray1.length(); j++) {
                JSONObject jsonObject = jArray1.getJSONObject(j);
                JSONObject jArray2 = jsonObject.getJSONObject("cases");

                active = jArray2.getString("new");
            }
        }

         return active;
    }
}
