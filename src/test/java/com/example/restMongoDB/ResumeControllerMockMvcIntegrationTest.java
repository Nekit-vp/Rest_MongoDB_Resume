package com.example.restMongoDB;


import com.example.restMongoDB.model.Address;
import com.example.restMongoDB.model.Gender;
import com.example.restMongoDB.model.Resume;
import com.example.restMongoDB.repository.ResumeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ResumeControllerMockMvcIntegrationTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ResumeRepository repository;
    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }

    @Test
    public void givenResume_whenAdd_thenStatus201andResumeReturned() throws Exception {

        Resume resume = createTestResume();

        mockMvc.perform(
                post("/api/resume")
                        .content(objectMapper.writeValueAsString(resume))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.age").isNumber())
                .andExpect(jsonPath("$.email").value("23dfw_21@mail.ru"))
                .andExpect(jsonPath("$.firstName").value("Nikita"));
    }


    @Test
    public void givenId_whenGetExistingResume_thenStatus200andResumeReturned() throws Exception {

        Resume resume = createTestResume();
        repository.save(resume);
        String id = resume.getId();

        mockMvc.perform(
                get("/api/resume/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.age").value(21))
                .andExpect(jsonPath("$.lastName").value("Joni"))
                .andExpect(jsonPath("$.firstName").value("Nikita"));
    }

    @Test
    public void givenId_whenGetNotExistingResume_thenStatus404anExceptionThrown() throws Exception {

        mockMvc.perform(
                get("/api/1"))
                .andExpect(status().isNotFound());

    }

    @Test
    public void giveResume_whenUpdate_thenStatus200andUpdatedReturns() throws Exception {

        Resume resume = createTestResume();
        repository.save(resume);
        resume.setFirstName("oleg");
        String id = resume.getId();


        mockMvc.perform(
                put("/api/resume/{id}", id)
                        .content(objectMapper.writeValueAsString(resume))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("oleg"));
    }

    @Test
    public void givenResume_whenDeleteResume_thenStatus200() throws Exception {

        Resume resume = createTestResume();
        repository.save(resume);
        String id = resume.getId();

        mockMvc.perform(
                delete("/api/resume/{id}", id))
                .andExpect(status().isOk());
    }

    private Resume createTestResume() {
        Resume resume = new Resume(
                "Nikita",
                "Joni",
                21,
                Gender.MALE,
                "23dfw_21@mail.ru",
                "programmer",
                new Address("Russia", "Kazan"),
                "8 998 652 36 43",
                "12536",
                50000,
                "cool man"

        );
        return resume;
    }
}
