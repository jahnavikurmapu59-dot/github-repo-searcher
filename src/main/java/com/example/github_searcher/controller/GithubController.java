package com.example.github_searcher.controller;

import com.example.github_searcher.model.RepositoryEntity;
import com.example.github_searcher.service.GithubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    // API 1: Search GitHub and save results
    @PostMapping("/search")
    public List<RepositoryEntity> searchRepositories(@RequestBody Map<String, String> request) {

        String query = request.get("query");
        String language = request.get("language");
        String sort = request.get("sort");

        return githubService.searchAndSave(query, language, sort);
    }

    // API 2: Get stored repositories
    @GetMapping("/repositories")
    public List<RepositoryEntity> getAllRepositories() {
        return githubService.getAllRepos();
    }
}
