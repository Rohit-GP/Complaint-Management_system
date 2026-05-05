package com.example.cms.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cms.Entity.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByUser_UserIdAndComplaint_ComplaintId(Long userId, Long complaintId);

    
}
