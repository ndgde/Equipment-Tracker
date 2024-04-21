package com.example.Entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Usage_History")
public class UsageHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Equipment_ID")
    private Equipment equipment;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_ID")
    private User user;
    
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String comments;

    
    public UsageHistory() {}

    public UsageHistory(Equipment equipment, User user, LocalDate startDate, LocalDate endDate, String reason, String comments) {
        this.equipment = equipment;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.comments = comments;
    }


    public Long getId() {
        return id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getReason() {
        return reason;
    }

    public String getComments() {
        return comments;
    }


    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void set(Equipment equipment, User user, LocalDate starDate, LocalDate endDate, String reason, String comments) {
        setEquipment(equipment);
        setUser(user);
        setStartDate(endDate);
        setEndDate(endDate);
        setReason(reason);
        setComments(comments);
    }
}
