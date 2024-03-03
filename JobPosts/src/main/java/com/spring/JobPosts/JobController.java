package com.spring.JobPosts;

import com.spring.JobPosts.model.JobPosts;
import com.spring.JobPosts.repository.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class JobController
{
    @Autowired
    private JobService service;

    @PostMapping("/jobpost")
    public void addpost(@RequestBody JobPosts post)
    {
        service.addpost(post);
    }

    @GetMapping("/jobpost")
    public List<JobPosts> getpost()
    {
        return service.getpost();
    }

    @PutMapping("/jobpost")
    public String update(@RequestBody JobPosts post)
    {
        service.update(post);
        return "Updated";
    }

    @DeleteMapping("/jobpost/{id}")
    public String delete(@PathVariable int id)
    {
        service.delete(id);
        return "Deleted";
    }
}
