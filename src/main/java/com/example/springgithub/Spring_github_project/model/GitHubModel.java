package com.example.springgithub.Spring_github_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GitHubModel {

    private String name;
    private String description;
    private String language;
}
