package de.secondparts.repository;

import de.secondparts.model.entity.OfferEntity;
import de.secondparts.model.entity.dtos.SearchOfferDTO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class OfferSpecification implements Specification<OfferEntity> {

    private final SearchOfferDTO searchOfferDTO;

    public OfferSpecification(SearchOfferDTO searchOfferDTO) {
        this.searchOfferDTO = searchOfferDTO;
    }

    @Override
    public Predicate toPredicate(Root<OfferEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate predicate = criteriaBuilder.conjunction();

        if (searchOfferDTO.getModel() != null && !searchOfferDTO.getModel().isEmpty()) {
            predicate.getExpressions().add(
                    criteriaBuilder.and(criteriaBuilder.equal(root.join("model").get("name"), searchOfferDTO.getModel()))
            );
        }

        if (searchOfferDTO.getVehicleIdentificationNumber() != null && !searchOfferDTO.getVehicleIdentificationNumber().isEmpty()) {
            predicate.getExpressions().add(
            criteriaBuilder
                    .and(criteriaBuilder.equal(root.get("vehicleIdentificationNumber"), searchOfferDTO.getVehicleIdentificationNumber())));
        }



        return predicate;
    }
}
