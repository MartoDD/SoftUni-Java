package com.resellerapp.repository;

import com.resellerapp.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    void removeOfferById(Long id);

    Set<Offer> findAllByUserId(Long id);

    Set<Offer> findAllByUserIdNot(Long id);

    Offer findOffersById(Long id);
}
