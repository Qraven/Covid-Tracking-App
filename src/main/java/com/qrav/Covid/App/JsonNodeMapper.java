package com.qrav.Covid.App;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JsonNodeMapper {

    public JSONObject convertToJSONObject(HttpResponse<JsonNode> response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JSONObject JSONresponse;

        JSONresponse=new JSONObject(mapper.writeValueAsString(response));

        return JSONresponse;
    }

}
