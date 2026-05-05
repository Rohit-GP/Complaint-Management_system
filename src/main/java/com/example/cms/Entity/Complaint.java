package com.example.cms.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Complaint {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;

    private String title;
    private String description;
    private String status;
    private String category;
    private LocalDate placedDate;
    private int priority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
