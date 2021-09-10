package com.ac.dataloader.dao;

import com.ac.dataloader.entity.orm.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Integer> {
}
