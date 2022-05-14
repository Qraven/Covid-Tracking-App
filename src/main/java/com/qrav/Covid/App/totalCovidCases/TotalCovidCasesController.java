package com.qrav.Covid.App.totalCovidCases;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TotalCovidCasesController {


    @Autowired
    private totalCovidCasesService totalCovidCasesService;

    @CrossOrigin("*")
    @RequestMapping("totalCases")
    public String getTotalCovidCases() throws UnirestException {
        return totalCovidCasesService.getTotalCovidCases();
    }

}
