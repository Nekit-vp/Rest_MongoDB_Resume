package com.example.restMongoDB.service;

import com.example.restMongoDB.model.Resume;
import com.example.restMongoDB.repository.ResumeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class ResumeService {

    private final ResumeRepository repository;

    public List<Resume> getAllResume() {
        return repository.findAll();
    }

    public Resume getResume(String id) {
        Optional<Resume> resume = repository.findById(id);
        return resume.get();
    }


    public Resume createResume(Resume resume) {
        resume.setFavoriteFilm(String.valueOf(getIdByFilm(resume.getFavoriteFilm())));
        return repository.save(resume);
    }

    public Resume updateResume(String id, Resume resume) {
        resume.setId(id);
        resume.setFavoriteFilm(String.valueOf(getIdByFilm(resume.getFavoriteFilm())));
        return repository.save(resume);
    }

    public String deleteResume(String id) {
        repository.deleteById(id);
        return id;
    }

    public int getIdByFilm(String film){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://watchlater.cloud.technokratos.com/search/film?query=" + film;
        TemplateForResponse response = restTemplate.getForObject(fooResourceUrl, TemplateForResponse.class);
        if((response != null) && (!response.getResults().isEmpty()))
            return response.getResults().get(0).getId();
        else return 0;
    }
}
