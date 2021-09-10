package com.ac.dataloader.services.impl;

import com.ac.dataloader.dao.JobRepository;
import com.ac.dataloader.dao.OrdersRepository;
import com.ac.dataloader.entity.orm.Job;
import com.ac.dataloader.entity.orm.JobStatus;
import com.ac.dataloader.services.DataLoadWorkerService;
import com.ac.dataloader.services.JobService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private DataLoadWorkerService dataLoadWorkerService;

    @Override
    public Job submitJob(String objectName, Class ormObject, CrudRepository objectCrudRepository, List<JsonNode> records) {
        Job job = new Job();
        job.setObjectName(objectName);
        job.setJobStatus(JobStatus.PENDING);
        jobRepository.save(job);
        dataLoadWorkerService.submitWorkerJob(objectName, ormObject, job, records, jobRepository, objectCrudRepository);
        return job;
    }

    public Optional<Job> getJobStatus(int jobId) {
        return jobRepository.findById(jobId);
    }

    @Override
    public List<Job> getAllJobs() {
        return (List<Job>) jobRepository.findAll();
    }
}
