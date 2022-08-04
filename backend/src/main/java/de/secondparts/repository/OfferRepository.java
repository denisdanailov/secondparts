package de.secondparts.repository;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.OfferEntity;
import de.secondparts.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long>, JpaSpecificationExecutor<OfferEntity> {

    List<OfferEntity> findAllByCategory(CategoryEntity category);

    List<OfferEntity> findAllBySeller(UserEntity user);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OfferEntity o WHERE o.isActive = false ")
    void clearRemovedOffers();

}
