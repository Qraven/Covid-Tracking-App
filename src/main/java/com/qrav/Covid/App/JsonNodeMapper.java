package com.qrav.Covid.App;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JsonNodeMapper {

    public String convertJsonResponseResponseToString(HttpResponse<JsonNode> jsonResponse) {

        JSONArray jsonArray = jsonResponse.getBody().getArray();
        String active = "";

        for (int i = 0; i < jsonArray.length(); i++) {
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
