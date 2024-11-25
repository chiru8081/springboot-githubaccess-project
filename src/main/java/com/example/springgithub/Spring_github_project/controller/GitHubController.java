package com.example.springgithub.Spring_github_project.controller;

import com.example.springgithub.Spring_github_project.model.GitHubModel;
import com.example.springgithub.Spring_github_project.model.GitHubModelEntity;
import com.example.springgithub.Spring_github_project.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GitHubController {

    @Autowired
    private GitHubService gitHubService;

    @GetMapping("/user/{userName}/repos")
    private ResponseEntity<List<GitHubModelEntity>> getUserRepos(@PathVariable String userName){

        List<GitHubModelEntity> demoProjects = gitHubService.getByUsername(userName);

        return new ResponseEntity<>(demoProjects, HttpStatus.OK);
    }

    @GetMapping("/repos/{language}")
    public ResponseEntity<List<GitHubModelEntity>> getReposByDescription(@PathVariable String language) {
        List<GitHubModelEntity> repositories = gitHubService.getByLanguage(language);
        return new ResponseEntity<>(repositories, HttpStatus.OK);
    }
}
