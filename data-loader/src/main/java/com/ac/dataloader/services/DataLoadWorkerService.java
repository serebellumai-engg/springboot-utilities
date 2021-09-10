package com.ac.dataloader.services;

import com.ac.dataloader.dao.JobRepository;
import com.ac.dataloader.entity.orm.Job;
import com.ac.dataloader.entity.orm.ORMObject;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DataLoadWorkerService {

    public void submitWorkerJob(String objectName, Class ormObject, Job job, List<JsonNode> records, JobRepository jobRepository, CrudRepository repository);
}
