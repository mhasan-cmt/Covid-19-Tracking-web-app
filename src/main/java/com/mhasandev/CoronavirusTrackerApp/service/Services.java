package com.mhasandev.CoronavirusTrackerApp.service;

import ch.qos.logback.core.net.server.Client;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.mhasandev.CoronavirusTrackerApp.entity.CountryInfo;
import com.mhasandev.CoronavirusTrackerApp.entity.TrackingStats;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class Services {
    private static final String RECORDS_URL =
            "https://corona.lmao.ninja/v2/countries?yesterday&sort";
        List<TrackingStats> records=new ArrayList<>();

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchData() throws IOException, InterruptedException {
        records.clear();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create(RECORDS_URL))
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        JSONArray jsonArray = new JSONArray(response.body());
        for (int i = 0; i < jsonArray.length(); i++) {
            TrackingStats trackingStats=new TrackingStats();
//            CountryInfo countryInfo=new CountryInfo();
        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
        trackingStats.setUpdated(jsonObject.getLong("updated"));
        trackingStats.setCountry(jsonObject.getString("country"));
//        countryInfo.set_id(jsonObject.getInt("_id"));
//        countryInfo.setIso2(jsonObject.getString("iso2"));
//        countryInfo.setIso3(jsonObject.getString("iso3"));
//        countryInfo.setLat(jsonObject.getInt("lat"));
//        countryInfo.setLongitude(jsonObject.getInt("long"));
//        countryInfo.setFlag(jsonObject.getString("flag"));
//        trackingStats.setCountryInfo(countryInfo);
        trackingStats.setCases(jsonObject.getInt("cases"));
        trackingStats.setTodayCases(jsonObject.getInt("todayCases"));
        trackingStats.setDeaths(jsonObject.getInt("deaths"));
        trackingStats.setTodayDeaths(jsonObject.getInt("todayDeaths"));
        trackingStats.setRecovered(jsonObject.getInt("recovered"));
        trackingStats.setTodayRecovered(jsonObject.getInt("todayRecovered"));
        trackingStats.setActive(jsonObject.getInt("active"));
        trackingStats.setCritical(jsonObject.getInt("critical"));
        trackingStats.setCasesPerOneMillion(jsonObject.getInt("casesPerOneMillion"));
        trackingStats.setDeathsPerOneMillion(jsonObject.getInt("deathsPerOneMillion"));
        trackingStats.setTests(jsonObject.getInt("tests"));
        trackingStats.setTestsPerOneMillion(jsonObject.getInt("testsPerOneMillion"));
        trackingStats.setPopulation(jsonObject.getInt("population"));
        trackingStats.setContinent(jsonObject.getString("continent"));
        trackingStats.setOneCasePerPeople(jsonObject.getInt("oneCasePerPeople"));
        trackingStats.setOneDeathPerPeople(jsonObject.getInt("oneDeathPerPeople"));
        trackingStats.setOneTestPerPeople(jsonObject.getInt("oneTestPerPeople"));
        trackingStats.setActivePerOneMillion(jsonObject.getDouble("activePerOneMillion"));
        trackingStats.setRecoveredPerOneMillion(jsonObject.getDouble("recoveredPerOneMillion"));
        trackingStats.setCriticalPerOneMillion(jsonObject.getDouble("criticalPerOneMillion"));
        records.add(trackingStats);
        }
        getRecords();
    }

    public List<TrackingStats> getRecords() {
        return records;
    }
}
