package de.secondparts.repository;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findById(Long id);

    Optional<CategoryEntity> findCategoryEntityByName(CategoryEnum name);

}
