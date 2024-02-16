package com.myhr.myhr.Domains.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "evaluations")
@Getter
@Setter
public class Evaluation {
    @Id
    @SequenceGenerator(name = "evaluation_sequence",sequenceName = "evaluation_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "evaluation_sequence")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne
    private Skill skill;
    @OneToMany(mappedBy = "evaluation")
    private Set<Question> questions = new HashSet<>();
    @OneToMany(mappedBy = "evaluation")
    private Set<TestRecord> testRecords = new HashSet<>();
}
