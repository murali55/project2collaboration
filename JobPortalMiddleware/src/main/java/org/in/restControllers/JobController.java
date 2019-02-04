package org.in.restControllers;

import java.util.Date;
import java.util.List;

import org.in.dataAccessObj.JobDao;
import org.in.persistanceClzs.ErrorClz;
import org.in.persistanceClzs.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController 
{
	public JobController()
	{
		System.out.println("Job controller bean is controller");
	}
	@Autowired
 private JobDao jobDao;	
	
	@RequestMapping(value="/addjob",method=RequestMethod.POST)
	public ResponseEntity<?>  addJob(@RequestBody Job job) 
	{
		try {
		job.setPostedOn(new Date());
		jobDao.addJob(job);
	}
		catch(Exception e)
		{
			ErrorClz errorClz= new ErrorClz(1,"job details could not inserted...Some thing went wrong"+e.getMessage());
			return new ResponseEntity<ErrorClz>(errorClz,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	return new ResponseEntity<Job>(job,HttpStatus.OK);
}
	@RequestMapping(value="/getalljobs",method=RequestMethod.GET)
	public ResponseEntity<?>  getAllJobs()
	{
		
    List<Job> jobs=jobDao.getAllJobs();
    if(jobs.isEmpty())
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	else
	return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK) ;	
	}
	
	@RequestMapping(value="/updatejob",method=RequestMethod.PUT)
	public ResponseEntity<?> updateJob(@RequestBody Job job)
	{
		try {
	    jobDao.updateJob(job);
		}
		catch(Exception e)
		{
		ErrorClz errorClz= new ErrorClz(2,"could not update.. some thing went wrong"+e.getMessage());
		return new ResponseEntity<ErrorClz>(errorClz,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	public ResponseEntity<?> getJob(@RequestBody int jobId)
	{
		Job job=jobDao.getJob(jobId);
	if(job==null)
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	else
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	
}