package com.example.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long   id;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "position")
    private String position;

    @JoinColumn(name = "department")
    private String department;

    @JoinColumn(name = "contact_information")
    private String contactInformation;


    public User() {}

    public User(String name, String position, String department, String contactInformation) {
        this.name               = name;
        this.position           = position;
        this.department         = department;
        this.contactInformation = contactInformation;
    }

    public User(User user) {
        this.name               = user.getName();
        this.position           = user.getPosition();
        this.department         = user.getDepartment();
        this.contactInformation = user.getContactInformation();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getContactInformation() {
        return contactInformation;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public void set(String name, String position, String department, String contactInformation) {
        this.name               = name;
        this.position           = position;
        this.department         = department;
        this.contactInformation = contactInformation;
    }
}
