package com.myhr.myhr.Domains.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Images")
@Table(name = "images")
public class Images {
    @Id
    @SequenceGenerator(
            name = "images_sequence",
            sequenceName = "images_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "images_sequence",
            strategy = jakarta.persistence.GenerationType.SEQUENCE
    )
    private Long id;
    @Column(name = "name", columnDefinition = "TEXT")
    private String name;
    @Column(name = "type", columnDefinition = "TEXT")
    private String type;
    @Column(name = "url", columnDefinition = "TEXT")
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Images images = (Images) o;
        return getId() != null && Objects.equals(getId(), images.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
