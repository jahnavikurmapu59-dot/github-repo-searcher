package com.example.github_searcher.service;

import com.example.github_searcher.model.RepositoryEntity;
import com.example.github_searcher.repository.RepoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GithubService {

    private final RepoRepository repoRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public GithubService(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    public List<RepositoryEntity> searchAndSave(String query, String language, String sort) {
        try {
            String url = "https://api.github.com/search/repositories?q="
                    + query + "+language:" + language + "&sort=" + sort;

            String response = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            JsonNode items = root.get("items");

            List<RepositoryEntity> savedList = new ArrayList<>();

            for (JsonNode item : items) {

                RepositoryEntity repo = new RepositoryEntity();
                repo.setGithubId(item.get("id").asLong());
                repo.setName(item.get("name").asText());
                repo.setDescription(item.get("description").asText(""));
                repo.setOwner(item.get("owner").get("login").asText());
                repo.setLanguage(item.get("language").asText(""));
                repo.setStars(item.get("stargazers_count").asInt());
                repo.setForks(item.get("forks_count").asInt());
                repo.setLastUpdated(LocalDateTime.now());

                repoRepository.save(repo);
                savedList.add(repo);
            }

            return savedList;

        } catch (Exception e) {
            throw new RuntimeException("GitHub API error");
        }
    }

    public List<RepositoryEntity> getAllRepos() {
        return repoRepository.findAll();
    }
}
