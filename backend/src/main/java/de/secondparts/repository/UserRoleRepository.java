package de.secondparts.repository;

import de.secondparts.model.entity.UserRoleEntity;
import de.secondparts.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    Optional<UserRoleEntity> findByName(UserRoleEnum name);
}
