package com.myhr.myhr.Domains.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Recruiter")
@Table(name = "recruiter")
public class Recruiter {
    @Id
    @SequenceGenerator(
            name = "recruiter_sequence",
            sequenceName = "recruiter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "recruiter_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @Column(name = "email", nullable = false, unique = true, columnDefinition = "TEXT")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Images> images;
    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Offer> offers;
    @Column(name = "active", columnDefinition = "BOOLEAN default false")
    private boolean active;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Recruiter recruiter = (Recruiter) o;
        return getId() != null && Objects.equals(getId(), recruiter.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
