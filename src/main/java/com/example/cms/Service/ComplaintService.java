package com.example.cms.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cms.Entity.User;
import com.example.cms.Repository.UserRepository;

import com.example.cms.Entity.Complaint;
import com.example.cms.Repository.ComplaintRepository;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;
 
    @Autowired
    private UserRepository userRepository;

    public Complaint postComplaint(Long userId, Complaint complaint) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        complaint.setUser(user);
        complaint.setPlacedDate(LocalDate.now());
        complaint.setStatus("OPEN");
        complaint.setPriority(0);

        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public List<Complaint> getComplaintsByStatus(String status) {
        return complaintRepository.findByStatus(status);
    }

    public List<Complaint> getComplaintsByCategory(String category) {
        return complaintRepository.findByCategory(category);
    }
}
