package com.ac.dataloader;

import com.ac.dataloader.config.DataLoaderMvcConfig;
import com.ac.dataloader.controller.DataLoaderController;
import com.ac.dataloader.services.DataLoadWorkerService;
import com.ac.dataloader.services.JobService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
        DataLoaderController.class,
        JobService.class, DataLoadWorkerService.class,
        DataLoaderMvcConfig.class})
public class DataLoaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataLoaderApplication.class, args);
    }
}
