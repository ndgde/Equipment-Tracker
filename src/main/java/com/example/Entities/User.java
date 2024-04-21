package com.example.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private String department;
    private String contactInformation;


    public User() {}

    public User(String name, String position, String department, String contactInformation) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.contactInformation = contactInformation;
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
        setName(name);
        setPosition(position);
        setDepartment(department);
        setContactInformation(contactInformation);
    }
}
