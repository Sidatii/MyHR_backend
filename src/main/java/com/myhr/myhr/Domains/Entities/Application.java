package com.myhr.myhr.Domains.Entities;

import com.myhr.myhr.Enums.Assessment;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "application")
@Table(name = "application")
public class Application {
    @Id
    @SequenceGenerator(
            name = "application_sequence",
            sequenceName = "application_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "application_sequence",
            strategy = jakarta.persistence.GenerationType.SEQUENCE
    )
    private Long id;
    @Column(name = "full_name", nullable = false, columnDefinition = "TEXT")
    private String fullName;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;
    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<File> files;
    @Column(name = "assessment")
    @Enumerated(EnumType.STRING)
    private Assessment assessment = Assessment.PENDING;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "offer_id", referencedColumnName = "id")
    private Offer offer;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Application that = (Application) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
