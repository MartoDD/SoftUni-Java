package com.example.mobilelele.models.entities;

import com.example.mobilelele.models.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public Role() {
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
