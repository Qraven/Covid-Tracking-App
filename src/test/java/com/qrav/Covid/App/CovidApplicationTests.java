package com.qrav.Covid.App;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CovidApplicationTests {

	@Test
	public void shouldReturnStatusOkay() throws UnirestException {
		HttpResponse<JsonNode> jsonResponse = Unirest.get("https://coronavirus-smartable.p.rapidapi.com/stats/v1/US/")
				.header("x-rapidapi-host", "coronavirus-smartable.p.rapidapi.com")
				.header("x-rapidapi-key", "0fab9d344bmsh9b31eff68954e63p1dc65bjsn5a4a922a3bd6")
				.asJson();
		;

		System.out.println(jsonResponse.getBody());
		System.out.println(jsonResponse.getStatus());
	}



}
