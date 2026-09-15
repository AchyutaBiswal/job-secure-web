package com.achyuta.JobSecureWeb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {

    @Id
    @Column(name = "id")
    private int postId;

    @Column(name = "title")
    private String postProfile;

    @Column(name = "description")
    private String postDesc;

    @Column(name = "experience")
    private Integer reqExperience;

    @Column(name = "skills", columnDefinition = "JSON")
    private String postTechStack;
}