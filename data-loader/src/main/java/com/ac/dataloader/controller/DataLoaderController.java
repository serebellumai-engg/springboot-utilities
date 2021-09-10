package com.ac.dataloader.controller;

import com.ac.dataloader.entity.orm.Job;
import com.ac.dataloader.services.JobService;
import com.ac.dataloader.util.Pair;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@RestController
@RequestMapping("data-loader")
public class DataLoaderController {

    @Autowired
    private JobService jobService;

    @Autowired
    private Properties properties;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/jobs", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String testApi() {
        return "OK";
    }

    @GetMapping(value = "/bulk/{id}/status", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Job> getBatchJobStatus(@PathVariable(name = "id") int jobId) throws Exception {
        Optional<Job> job = jobService.getJobStatus(jobId);
        return jobService.getJobStatus(jobId);
    }

    @PostMapping(value = "/bulk/{objectName}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Job batchUploadJob(@RequestBody List<JsonNode> records,
                              @PathVariable String objectName) {
        Job job = null;
        if (!properties.containsKey(objectName)) {
            job = new Job();
            job.setErrorMessage("Object not supported");
        } else {
            Pair pair = (Pair) properties.get(objectName);
            job = jobService.submitJob(objectName, (Class) pair.getKey(),
                    (CrudRepository) pair.getValue()
                    , records);
        }
        return job;
    }
}
