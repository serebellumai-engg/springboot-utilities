package com.ac.dataloader.services;

import com.ac.dataloader.entity.orm.Job;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JobService {

    Job submitJob(String objectName, Class ormObject, CrudRepository objectCrudRepository, List<JsonNode> records);

    Optional<Job> getJobStatus(int jobId);

    List<Job> getAllJobs();
}
