
package com.example.SpringJobApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringJobApp.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

	List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
	
}

/*
 * List<JobPost> jobs = new ArrayList<>(Arrays.asList( new JobPost(1,
 * "Frontend Developer",
 * "Experience in building responsive web applications using React", 3,
 * List.of("HTML", "CSS", "JavaScript", "React")), new JobPost(2,
 * "Frontend Developer",
 * "Experience in building responsive web applications using React", 3,
 * List.of("HTML", "CSS", "JavaScript", "React")), new JobPost(5,
 * "Mobile App Developer",
 * "Experience in mobile app development for iOS and Android", 3,
 * List.of("iOS Development", "Android Development", "Mobile App")), new
 * JobPost(6, "DevOps Engineer",
 * "Implement and manage continuous integration and delivery pipelines", 4,
 * List.of("DevOps", "CI/CD", "Docker", "Kubernetes"))));
 * 
 * public List<JobPost> getAllJobs() { return jobs; }
 * 
 * public void addJob(JobPost job) { jobs.add(job);
 * System.out.println("Job added: " + jobs); }
 * 
 * public JobPost getJob(int jobId) { for (JobPost job: jobs) {
 * if(job.getPostId() == jobId) { return job; } } return null; }
 * 
 * public void updateJobPost(JobPost jobPost) { for (JobPost job: jobs) {
 * if(job.getPostId() == jobPost.getPostId()) {
 * job.setPostDesc(jobPost.getPostDesc());
 * job.setPostProfile(jobPost.getPostProfile());
 * job.setPostTechStack(jobPost.getPostTechStack());
 * job.setReqExperience(jobPost.getReqExperience()); } } }
 * 
 * public void deleteJobPost(int jobId) { // TODO Auto-generated method stub for
 * (JobPost job: jobs) { if(job.getPostId() == jobId) { jobs.remove(jobId);
 * break; } } }
 */