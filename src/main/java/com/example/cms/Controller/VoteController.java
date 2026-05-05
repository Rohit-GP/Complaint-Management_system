package com.example.cms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cms.Service.VoteService;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/cast")
    public String vote(@RequestParam Long userId, @RequestParam Long complaintId) {
        return voteService.voteComplaint(userId, complaintId);
    }
}