package com.ac.dataloader.services.impl;

import com.ac.dataloader.dao.JobRepository;
import com.ac.dataloader.entity.orm.Job;
import com.ac.dataloader.entity.orm.ORMObject;
import com.ac.dataloader.services.DataLoadWorkerService;
import com.ac.dataloader.work.DataLoadWorker;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataLoadWorkerServiceImpl implements DataLoadWorkerService {

    @Autowired
    private TaskExecutor executor;

    public void submitWorkerJob(String objectName, Class ormObject, Job job, List<JsonNode> records, JobRepository jobRepository, CrudRepository repository) {
        executor.execute(new DataLoadWorker(job, ormObject, jobRepository, repository, records, executor));
    }

}
