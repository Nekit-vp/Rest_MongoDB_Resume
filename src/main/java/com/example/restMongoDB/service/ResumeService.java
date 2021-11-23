package com.example.restMongoDB.service;

import com.example.restMongoDB.model.Resume;
import com.example.restMongoDB.resource.ResumeResource;
import com.example.restMongoDB.repository.ResumeRepository;
import mapper.SimpleResumeResourceMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ResumeService {

    private final ResumeRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final SimpleResumeResourceMapper mapper
            = Mappers.getMapper(SimpleResumeResourceMapper.class);

    public ResumeService(ResumeRepository repository) {
        this.repository = repository;
    }

    public List<ResumeResource> getAllResume() {
        List<Resume> resumeList = repository.findAll();
        return resumeList.stream()
                .map(mapper::resumeToResource)
                .collect(Collectors.toList());
    }

    public ResumeResource getResume(String id) {
        Optional<Resume> resume = repository.findById(id);
        return mapper.resumeToResource(resume.get());
    }


    public ResumeResource createResume(ResumeResource resumeResource) {
        resumeResource.setFavoriteFilm(String.valueOf(getIdByFilm(resumeResource.getFavoriteFilm())));
        resumeResource.setId(null);
        Resume resume = mapper.resourceToResume(resumeResource);
        return mapper.resumeToResource(repository.save(resume));
    }

    public ResumeResource updateResume(String id, ResumeResource resumeResource) {
        Resume resume = mapper.resourceToResume(resumeResource);
        resume.setId(id);
        resume.setFavoriteFilm(String.valueOf(getIdByFilm(resume.getFavoriteFilm())));
        return mapper.resumeToResource(repository.save(resume));
    }

    public String deleteResume(String id) {
        repository.deleteById(id);
        return id;
    }

    public int getIdByFilm(String film){
        String fooResourceUrl = "https://watchlater.cloud.technokratos.com/search/film?query=" + film;
        TemplateForResponse response = restTemplate.getForObject(fooResourceUrl, TemplateForResponse.class);
        if((response != null) && (!response.getResults().isEmpty()))
            return response.getResults().get(0).getId();
        else return 0;
    }
}
