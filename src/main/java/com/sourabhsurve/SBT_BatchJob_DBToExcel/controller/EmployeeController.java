package com.sourabhsurve.SBT_BatchJob_DBToExcel.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job exportEmployeeJob;



        @Autowired
        private Job updateExperienceJob;

          @PostMapping("/update")
        //@PostConstruct
        public ResponseEntity<String> updateExperience() throws JobExecutionException {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("jobName", "updateExperienceJob")
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(updateExperienceJob, jobParameters);
            return ResponseEntity.ok("Update experience of Employee  successfully.");
        }
    }


