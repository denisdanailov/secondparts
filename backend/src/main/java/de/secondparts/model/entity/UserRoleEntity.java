package de.secondparts.model.entity;

import de.secondparts.model.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name ="roles")
public class UserRoleEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserRoleEnum name;

    public UserRoleEntity() {
    }

    public UserRoleEnum getName() {
        return name;
    }

    public UserRoleEntity setName(UserRoleEnum name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "userRole=" + name +
                '}';
    }
}
