package com.spring.JobPosts.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPosts
{
    @Id
    private int id;
    private String description;
    private int experience;
    private List<String> techstack;
}
