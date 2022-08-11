package de.secondparts.repository;

import de.secondparts.model.entity.ShoppingCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShoppingCardRepository extends JpaRepository<ShoppingCardEntity, Long> {

    List<ShoppingCardEntity> findShoppingCardEntityByBuyerId(Long id);


}