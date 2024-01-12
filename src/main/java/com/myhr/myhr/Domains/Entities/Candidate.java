package com.myhr.myhr.Domains.Entities;

import com.myhr.myhr.Enums.Level;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Entity(name = "agent")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Candidate extends User{

    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Enumerated(EnumType.STRING)
    private Level level;
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Application> applications;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Candidate candidate = (Candidate) o;
        return getPhone() != null && Objects.equals(getPhone(), candidate.getPhone());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(phone);
    }
}
