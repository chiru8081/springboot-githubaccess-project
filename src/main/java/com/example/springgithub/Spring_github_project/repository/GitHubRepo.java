package com.example.springgithub.Spring_github_project.repository;

import com.example.springgithub.Spring_github_project.model.GitHubModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GitHubRepo extends JpaRepository<GitHubModelEntity, Long> {

    @Query("select g from GitHubModelEntity g where g.language = ?1")
    List<GitHubModelEntity> findByLanguage(String language);


}
