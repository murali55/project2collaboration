package org.in.restControllers;

import org.in.dataAccessObj.JobDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class JobController 
{
	public JobController()
	{
		System.out.println("Job controller bean is controller");
	}
	//@Autowired
 private JobDao jobDao;	
	
}
