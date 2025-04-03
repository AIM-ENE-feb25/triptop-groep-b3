package com.mycompany.app;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class App {
    public static void main(String[] args) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://tripadvisor16.p.rapidapi.com/api/v1/cruises/searchCruises?destinationId=153339&order=popularity&page=1&currencyCode=USD")
                .header("x-rapidapi-key", "c452026785mshc8264ef962b3f2ep1e8bf4jsnd53f115ee8cd")
                .header("x-rapidapi-host", "tripadvisor16.p.rapidapi.com")
                .asString();
        System.out.println(response.getBody());
    }
}