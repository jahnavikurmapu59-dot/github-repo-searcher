package com.example.github_searcher.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "repositories")
@Data
public class RepositoryEntity {

    @Id
    private Long githubId;

    private String name;

    @Column(length = 2000)
    private String description;

    private String owner;

    private String language;

    private int stars;

    private int forks;

    private LocalDateTime lastUpdated;
}
