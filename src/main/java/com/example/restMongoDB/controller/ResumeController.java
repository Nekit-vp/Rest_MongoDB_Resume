package com.example.restMongoDB.controller;


import com.example.restMongoDB.model.Resume;
import com.example.restMongoDB.resource.ResumeResource;
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
    public ResponseEntity<List<ResumeResource>> getAllResume() {
        List<ResumeResource> resumeList = resumeService.getAllResume();
        return ResponseEntity.ok(resumeList);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResumeResource> getResume(@PathVariable String id) {
        ResumeResource resumeResource = resumeService.getResume(id);
        return ResponseEntity.ok(resumeResource);
    }

    @PostMapping
    public ResponseEntity<ResumeResource> postResume(@RequestBody ResumeResource resumeResource) {
        ResumeResource resume = resumeService.createResume(resumeResource);
        return ResponseEntity.ok(resume);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResumeResource> putResume(@PathVariable String id, @RequestBody ResumeResource resumeResource){
        ResumeResource resume = resumeService.updateResume(id, resumeResource);
        return ResponseEntity.ok(resume);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteResume(@PathVariable String id) {
        String result = resumeService.deleteResume(id);
        return ResponseEntity.ok(result);
    }
}
