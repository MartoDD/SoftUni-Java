package com.example.football.repository;

import com.example.football.models.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {

    Optional<Stat> findStatByShootingAndEnduranceAndPassing(BigDecimal shooting, BigDecimal endurance, BigDecimal passing);

}
