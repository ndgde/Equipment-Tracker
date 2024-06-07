package com.example.Entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "equipments")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long      id;

    @JoinColumn(name = "name")
    private String    name;

    @JoinColumn(name = "type")
    private String    type;

    @JoinColumn(name = "description")
    private String    description;

    @JoinColumn(name = "acquisition_date")
    private LocalDate acquisitionDate;

    @JoinColumn(name = "cost")
    private double    cost;

    @JoinColumn(name = "status")
    private String    status;

    @JoinColumn(name = "image")
    private String    image;

    @JoinColumn(name = "state")
    private String state;


    public Equipment() {}

    public Equipment(String name, String type, String description, 
        LocalDate acquisitionDate, double cost, String status, String image, String state) {
        this.name            = name;
        this.type            = type;
        this.description     = description;
        this.acquisitionDate = acquisitionDate;
        this.cost            = cost;
        this.status          = status;
        this.image           = image;
    }

    public Equipment(Equipment equipment) {
        this.name            = equipment.getName();
        this.type            = equipment.getType();
        this.description     = equipment.getDescription();
        this.acquisitionDate = equipment.getAcquisitionDate();
        this.cost            = equipment.getCost();
        this.status          = equipment.getStatus();
        this.image           = equipment.getImage();
        this.state           = equipment.getState();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public double getCost() {
        return cost;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public String getState() {
        return state;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void set(String name, String type, String description, 
        LocalDate acquisitionDate, double cost, String status, String image) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.acquisitionDate = acquisitionDate;
        this.cost = cost;
        this.status = status;
        this.image = image;
    }
}
