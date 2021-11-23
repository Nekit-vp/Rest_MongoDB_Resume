package com.example.restMongoDB.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateForResponse {

    private int resultsOnPage;
    private List<TemplateFilm> results;

    public int getResultsOnPage() {
        return resultsOnPage;
    }

    public void setResultsOnPage(int resultsOnPage) {
        this.resultsOnPage = resultsOnPage;
    }

    public List<TemplateFilm> getResults() {
        return results;
    }

    public void setResults(List<TemplateFilm> results) {
        this.results = results;
    }
}


@JsonIgnoreProperties(ignoreUnknown = true)
class TemplateFilm{
    private String originalTitle;
    private String title;
    private int id;

    public String getOriginalTitle() {

        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
