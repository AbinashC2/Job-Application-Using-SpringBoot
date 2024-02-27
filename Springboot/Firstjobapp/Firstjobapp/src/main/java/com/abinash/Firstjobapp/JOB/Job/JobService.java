package com.abinash.Firstjobapp.JOB.Job;

import java.util.List;

public interface JobService {
    List<Job>findAll();
    void createJob(Job job);

    Job getJobByID(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job updateJob);
}
