package com.example.Entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "usage_history")
public class UsageHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long      id;
    
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User      user;
    
    @JoinColumn(name = "start_date")
    private LocalDate startDate;

    @JoinColumn(name = "end_date")
    private LocalDate endDate;

    @JoinColumn(name = "reason")
    private String    reason;

    @JoinColumn(name = "comments")
    private String    comments;

    
    public UsageHistory() {}

    public UsageHistory(Equipment equipment, User user, LocalDate startDate, 
        LocalDate endDate, String reason, String comments) {
        this.equipment = equipment;
        this.user      = user;
        this.startDate = startDate;
        this.endDate   = endDate;
        this.reason    = reason;
        this.comments  = comments;
    }
    
    public UsageHistory(UsageHistory usageHistory) {
        this.equipment = usageHistory.getEquipment();
        this.user      = usageHistory.getUser();
        this.startDate = usageHistory.getStartDate();
        this.endDate   = usageHistory.getEndDate();
        this.reason    = usageHistory.getReason();
        this.comments  = usageHistory.getComments();
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
        this.equipment = equipment;
        this.user      = user;
        this.startDate = starDate;
        this.endDate   = endDate;
        this.reason    = reason;
        this.comments  = comments;
    }
}
