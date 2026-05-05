package com.example.cms.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean upvote;

    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaint complaint;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
