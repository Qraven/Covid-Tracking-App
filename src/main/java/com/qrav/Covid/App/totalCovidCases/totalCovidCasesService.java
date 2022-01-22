package com.qrav.Covid.App.totalCovidCases;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class totalCovidCasesService {

    public String getTotalCovidCases() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://covid-193.p.rapidapi.com/statistics?country=all")
                .header("x-rapidapi-host", "covid-193.p.rapidapi.com")
                .header("x-rapidapi-key", "0fab9d344bmsh9b31eff68954e63p1dc65bjsn5a4a922a3bd6")
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
