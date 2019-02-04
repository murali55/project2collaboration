package org.in.dataAccessObj;

import java.util.List;

import org.in.persistanceClzs.Job;

public interface JobDao 
{
 public void addJob(Job job);
 public List<Job> getAllJobs();
 public  Job getJob(int jobId);
 public void deleteJob(int jobId);
 public  Job updateJob(Job job);
}
