package com.example.Entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String description;
    private LocalDate acquisitionDate;
    private double cost;
    private String status;
    private String image;


    public Equipment() {}

    public Equipment(String name, String type, String description, LocalDate acquisitionDate, double cost, String status, String image) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.acquisitionDate = acquisitionDate;
        this.cost = cost;
        this.status = status;
        this.image = image;
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
}
