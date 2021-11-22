package com.example.restMongoDB.resource;

import com.example.restMongoDB.model.Address;
import com.example.restMongoDB.model.Gender;
import com.example.restMongoDB.model.Resume;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResumeResource implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String email;
    private String profile;
    private Address address;
    private String phone;
    private String favoriteFilm;
    private int salary;
    private String about;

    public ResumeResource() {
    }

    public ResumeResource(Resume resume) {
        this.id = resume.getId();
        this.firstName = resume.getFirstName();
        this.lastName = resume.getLastName();
        this.age = resume.getAge();
        this.gender = resume.getGender();
        this.email = resume.getEmail();
        this.profile = resume.getProfile();
        this.address = resume.getAddress();
        this.phone = resume.getPhone();
        this.favoriteFilm = resume.getFavoriteFilm();
        this.salary = resume.getSalary();
        this.about = resume.getAbout();
    }

    public Resume getModel() {
        return new Resume(
                this.firstName,
                this.lastName,
                this.age,
                this.gender,
                this.email,
                this.profile,
                this.address,
                this.phone,
                this.favoriteFilm,
                this.salary,
                this.about
        );
    }
}
