package com.spring.JobPosts.repository;

import com.spring.JobPosts.model.JobPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repo;

    public void addpost(JobPosts post)
    {
        repo.save(post);
    }

    public List<JobPosts> getpost()
    {
        return repo.findAll();
    }

    public void update(JobPosts post)
    {
        repo.save(post);
    }

    public void delete(int id)
    {
        repo.deleteById(id);
    }
}
