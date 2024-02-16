package com.myhr.myhr.Domains.Entities;

import com.myhr.myhr.Enums.EvaluationStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "test_records")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TestRecord {
    @Id
    @SequenceGenerator(name = "test_record_sequence",sequenceName = "test_record_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_record_sequence")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Candidate candidate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Evaluation evaluation;
    @Column(name = "taken_at")
    @CreationTimestamp
    private Date TakenAt;
    @Column(name = "result")
    private String result;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EvaluationStatus status;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TestRecord that = (TestRecord) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
