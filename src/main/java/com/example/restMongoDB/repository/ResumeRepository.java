package com.example.restMongoDB.repository;

import com.example.restMongoDB.model.Resume;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResumeRepository extends MongoRepository<Resume, String> {
}
