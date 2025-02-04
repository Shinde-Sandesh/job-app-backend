package com.example.SpringJobApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringJobApp.model.JobPost;
import com.example.SpringJobApp.service.JobService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobRestController {

	@Autowired
	private JobService service;

	@GetMapping("jobPosts")
	public List<JobPost> getAllJobs() {
		System.out.println("RESPONSE");
		return service.getAllJobPosts();
	}

	@GetMapping("jobPost/{jobId}")
	public JobPost getJobPost(@PathVariable("jobId") int jobId) {
		return service.getJob(jobId);
	}

	@PostMapping("jobPost")
	public JobPost addJob(@RequestBody JobPost jobPost) {
		service.addJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
		return service.search(keyword);
	}

	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		service.updateJobPost(jobPost);
		return service.getJob(jobPost.getPostId());
	}

	@DeleteMapping("jobPost/{jobId}")
	public String deleteJobPost(@PathVariable("jobId") int jobId) {
		service.deleteJobPost(jobId);
		return "Job Post Deleted";
	}

	@GetMapping("load")
	public String load() {
		service.load();
		return "Success";
	}

}
