package com.myhr.myhr.Domains.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disciplines")
@Getter
@Setter
public class Discipline {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "icon")
    private String icon;
    @OneToMany(mappedBy = "discipline")
    private Set<Skill> skills;
    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY)
    private Set<Candidate> candidate = new HashSet<>();
}
