
package com.example.SpringJobApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringJobApp.jobmodel.JobPost;
import com.example.SpringJobApp.repo.job.JobRepo;

@Service
public class JobService {

	@Autowired
	private JobRepo jobRepo;

	public void addJob(JobPost jobPost) {
		jobRepo.save(jobPost);
	}

	public List<JobPost> getAllJobPosts() {
		return jobRepo.findAll();
	}

	public JobPost getJob(int jobId) {
		return jobRepo.findById(jobId).orElse(new JobPost());
	}

	public void updateJobPost(JobPost jobPost) {
		jobRepo.save(jobPost);
	}

	public void deleteJobPost(int jobId) {
		jobRepo.deleteById(jobId);
	}

	public void load() {
		// TODO Auto-generated method stub
		List<JobPost> jobs = new ArrayList<>(List.of(
				new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3,
						List.of("Java", "Spring", "SQL")),
				new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5,
						List.of("Python", "Machine Learning", "TensorFlow")),
				new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.",
						2, List.of("JavaScript", "React", "CSS")),
				new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4,
						List.of("Cisco", "Routing", "Firewalls")),
				new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3,
						List.of("UI/UX Design", "Adobe XD", "Prototyping"))

		));

		jobRepo.saveAll(jobs);
	}

	public List<JobPost> search(String keyword) {
		return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
	}
}
