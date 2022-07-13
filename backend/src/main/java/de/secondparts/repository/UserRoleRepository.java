package de.secondparts.repository;

import de.secondparts.model.entity.UserRoleEntity;
import de.secondparts.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    UserRoleEntity findByName(UserRoleEnum name);
}
