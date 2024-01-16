package com.myhr.myhr.Domains.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "admin")
public class Admin extends User{

    @Column(name = "position", nullable = true, columnDefinition = "TEXT")
    private String position;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Admin admin = (Admin) o;
        return getPhone() != null && Objects.equals(getPhone(), admin.getPhone());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(phone);
    }
}
