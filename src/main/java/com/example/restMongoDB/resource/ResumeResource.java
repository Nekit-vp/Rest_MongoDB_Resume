package com.example.restMongoDB.resource;

import com.example.restMongoDB.model.Address;
import com.example.restMongoDB.model.Gender;
import com.example.restMongoDB.model.Resume;

public class ResumeResource {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFavoriteFilm() {
        return favoriteFilm;
    }

    public void setFavoriteFilm(String favoriteFilm) {
        this.favoriteFilm = favoriteFilm;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Resume toModel() {
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
