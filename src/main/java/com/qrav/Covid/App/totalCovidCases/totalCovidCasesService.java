package com.qrav.Covid.App.totalCovidCases;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.qrav.Covid.App.PrivateKey;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class totalCovidCasesService {

    @Autowired
    PrivateKey privateKey;

    public String getTotalCovidCases() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://covid-193.p.rapidapi.com/statistics?country=all")
                .header("x-rapidapi-host", "covid-193.p.rapidapi.com")
                .header("x-rapidapi-key", privateKey.getPRIVATEKEY())
                .asJson();

        JSONArray jsonArray = jsonResponse.getBody().getArray();
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
