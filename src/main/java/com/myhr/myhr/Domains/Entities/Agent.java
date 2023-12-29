package com.myhr.myhr.Domains.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "agent")
@Table(name = "agent")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Agent {
    @Id
    @SequenceGenerator(
            name = "agent_sequence",
            sequenceName = "agent_sequence",
            allocationSize = 1
    )
    @jakarta.persistence.GeneratedValue(
            generator = "agent_sequence",
            strategy = jakarta.persistence.GenerationType.SEQUENCE
    )
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;
    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;
}
