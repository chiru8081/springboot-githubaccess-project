package com.example.springgithub.Spring_github_project.repository;

import com.example.springgithub.Spring_github_project.model.GitHubModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GitHubRepo extends JpaRepository<GitHubModelEntity, Long> {

//    select g: Selects all fields of the entity GitHubModelEntity.
//    from GitHubModelEntity g: Specifies the entity GitHubModelEntity
//    as the source of the query and assigns it an alias g.
//    where g.language = ?1: Filters the results where the language field
//    of the GitHubModelEntity matches the first parameter of the method (represented by ?1).
//
    @Query("select g from GitHubModelEntity g where g.language = ?1")
    List<GitHubModelEntity> findByLanguage(String language);


}
