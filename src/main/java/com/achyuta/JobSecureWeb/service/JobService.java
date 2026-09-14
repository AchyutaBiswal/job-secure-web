package com.achyuta.JobSecureWeb.service;

import com.achyuta.JobSecureWeb.model.JobPost;
import com.achyuta.JobSecureWeb.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public List<JobPost> getAlljobs() {
        return repo.getAllJobs();
    }

    public JobPost getJob(int postId) {
        return repo.getJob(postId);
    }

    public void updateJob(JobPost jobPost) {
        // Replace the existing job with matching postId
        deleteJob(jobPost.getPostId());
        repo.addJob(jobPost);
    }

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public void deleteJob(int postId) {
        repo.getAllJobs().removeIf(job -> job.getPostId() == postId);
    }
}