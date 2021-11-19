package com.example.restMongoDB.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Resume {

    @Id
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

    public Resume(String firstName,
                  String lastName,
                  int age, Gender gender,
                  String email,
                  String profile,
                  Address address,
                  String phone,
                  String favoriteFilm,
                  int salary,
                  String about) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.profile = profile;
        this.address = address;
        this.phone = phone;
        this.favoriteFilm = favoriteFilm;
        this.salary = salary;
        this.about = about;
    }
}
