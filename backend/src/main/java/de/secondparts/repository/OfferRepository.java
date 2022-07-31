package de.secondparts.repository;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    List<OfferEntity> findAllByCategory(CategoryEntity category);

}
