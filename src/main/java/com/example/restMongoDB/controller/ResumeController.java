package com.example.restMongoDB.controller;


import com.example.restMongoDB.model.Resume;
import com.example.restMongoDB.service.ResumeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/resume")
@AllArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping
    public ResponseEntity<?> getAllResume() {
        List<Resume> resumeList = resumeService.getAllResume();
        return ResponseEntity.ok(resumeList);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getResume(@PathVariable String id) {
        Resume resume = resumeService.getResume(id);
        return ResponseEntity.ok(resume);
    }

    @PostMapping
    public ResponseEntity<?> postResume(@RequestBody Resume resume) {
        Resume resumeNew = resumeService.createResume(resume);
        return ResponseEntity.ok(resumeNew);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putResume(@PathVariable String id, @RequestBody Resume resume){
        Resume resumeNew = resumeService.updateResume(id, resume);
        return ResponseEntity.ok(resumeNew);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteResume(@PathVariable String id) {
        String result = resumeService.deleteResume(id);
        return ResponseEntity.ok(result);
    }
}
