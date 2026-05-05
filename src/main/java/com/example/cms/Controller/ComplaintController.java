package com.example.cms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cms.Entity.Complaint;
import com.example.cms.Service.ComplaintService;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/create/{userId}")
    public Complaint postComplaint(@PathVariable Long userId, @RequestBody Complaint complaint) {
        return complaintService.postComplaint(userId, complaint);
    }

    @GetMapping
    public List<Complaint> getAll() {
        return complaintService.getAllComplaints();
    }

    @GetMapping("/status")
    public List<Complaint> getByStatus(@RequestParam String status) {
        return complaintService.getComplaintsByStatus(status);
    }

    @GetMapping("/complaints/{category}")
    public List<Complaint> getByCatrgory(@PathVariable String category) {
        return complaintService.getComplaintsByCategory(category);
    }
}