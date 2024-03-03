package com.spring.JobPosts.repository;

import com.spring.JobPosts.model.JobPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobPosts,Integer> {
}
