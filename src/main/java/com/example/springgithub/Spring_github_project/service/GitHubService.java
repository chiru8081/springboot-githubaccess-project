package com.example.springgithub.Spring_github_project.service;

import com.example.springgithub.Spring_github_project.model.GitHubModel;
import com.example.springgithub.Spring_github_project.model.GitHubModelEntity;
import com.example.springgithub.Spring_github_project.repository.GitHubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubService {

    private RestTemplate restTemplate;

    @Autowired
    private GitHubRepo gitHubRepo;

    public GitHubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubModelEntity> getByUsername(String userName) {

        String url = UriComponentsBuilder.fromHttpUrl("https://api.github.com/users/{userName}/repos")
                .buildAndExpand(userName)
                .toUriString();

        GitHubModel[] repositories = restTemplate.getForObject(url, GitHubModel[].class);

        List<GitHubModelEntity> entities = Arrays.stream(repositories)
                .map(this::convertToEntity)
                .collect(Collectors.toList());

        gitHubRepo.saveAll(entities);

        return entities;

    }

    public List<GitHubModelEntity> getByLanguage(String language) {
        return gitHubRepo.findByLanguage(language);  // Fetch repositories by language
    }

    public GitHubModelEntity convertToEntity(GitHubModel gitHubModel){

        return GitHubModelEntity.builder()
                .name(gitHubModel.getName())
                .description(gitHubModel.getDescription())
                .language(gitHubModel.getLanguage())
                .build();
    }
}
