package com.SpringBoot_Project_2.JobApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.SpringBoot_Project_2.JobApp.Model.JobPost;
import com.SpringBoot_Project_2.JobApp.service.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    // ************************************************************************

    @GetMapping({ "/", "/home" })
    public String home() {
        return "home";
    }

    // ************************************************************************

    @RequestMapping("/addjob")
    public String addJob() {
        return "addjob";
    }

    // ************************************************************************

    // controller method for getting all job posts
    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {

        List<JobPost> jobPosts = service.returnAllJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewAllJobs";
    }

    // ************************************************************************

    @PostMapping("/handleForm")
    public String handleAddJobForm(JobPost jobPost, Model model) {
        model.addAttribute("jobPost", jobPost);
        service.addJobPost(jobPost);
        // System.out.println(jobPost);
        return "success";

    }

}
