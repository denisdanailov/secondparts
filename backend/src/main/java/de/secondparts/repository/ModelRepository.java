package de.secondparts.repository;

import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.dtos.ModelViewDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    @Query("select m from ModelEntity m where m.brand.Id = :brand")
    List<ModelEntity> findAllModelsByBrandId(@Param("brand")Long brandId);

    Optional<ModelEntity> findByName(String name);
}
