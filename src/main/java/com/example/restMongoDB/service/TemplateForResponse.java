package com.example.restMongoDB.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateForResponse {

    private int resultsOnPage;
    private List<TemplateFilm> results;

}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class TemplateFilm{
    private String originalTitle;
    private String title;
    private int id;
}
