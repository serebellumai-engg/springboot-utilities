package com.ac.dataloader.work;

import com.ac.dataloader.dao.JobRepository;
import com.ac.dataloader.entity.orm.Job;
import com.ac.dataloader.entity.orm.JobStatus;
import com.ac.dataloader.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public class DataLoadWorker implements Runnable {
    private Job job;
    private JobRepository jobRepository;
    private CrudRepository objectRepository;
    private Class ormObject;
    private List<JsonNode> records;
    private TaskExecutor executor;

    public DataLoadWorker(Job job, Class ormObject, JobRepository jobRepository,
                          CrudRepository objectRepository, List<JsonNode> records,
                          TaskExecutor executor) {
        this.job = job;
        this.ormObject = ormObject;
        this.jobRepository = jobRepository;
        this.objectRepository = objectRepository;
        this.records = records;
        this.executor = executor;
    }

    @Override
    public void run() {
        job.setJobStatus(JobStatus.RUNNING);
        job.setTotalRecords(records.size());
        jobRepository.save(job);
        try {
            List convertedObjects = JsonUtil.convertJsonNodeToObject(ormObject, records);
            objectRepository.saveAll(convertedObjects);
            job.setJobStatus(JobStatus.COMPLETED);
        } catch (JsonProcessingException e) {
            job.setJobStatus(JobStatus.FAILED);
            job.setErrorMessage(e.getMessage());
        }
        job.setEndTime(new Date());
        jobRepository.save(job);
    }
}
