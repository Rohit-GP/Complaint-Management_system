package com.example.cms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cms.Entity.Vote;
import com.example.cms.Repository.VoteRepository;

import com.example.cms.Entity.User;
import com.example.cms.Repository.UserRepository;

import com.example.cms.Entity.Complaint;
import com.example.cms.Repository.ComplaintRepository;

@Service
public class VoteService {
    
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    public String voteComplaint(Long userId, Long complaintId) {

        if (voteRepository.findByUser_UserIdAndComplaint_ComplaintId(userId, complaintId)
                .isPresent()) {
            return "You have already voted";
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        Vote vote = new Vote();
        vote.setUser(user);
        vote.setComplaint(complaint);
        vote.setUpvote(true);

        voteRepository.save(vote);

        complaint.setPriority(complaint.getPriority() + 1);
        complaintRepository.save(complaint);

        return "Vote added successfully";
    }
    

}


