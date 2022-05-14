package com.qrav.Covid.App.dailyCovidCases;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidCasesController {

    @Autowired
    private CovidCasesService covidCasesService;

    @CrossOrigin("*")
    @RequestMapping("/cases")
    public String returnCovidCases(@RequestParam String country) throws UnirestException {
        return covidCasesService.getCovidCases(country);
    }

}
