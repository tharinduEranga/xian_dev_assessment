package com.xian.assessment.repository;

import com.xian.assessment.model.entity.PriceStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceStructureRepository extends JpaRepository<PriceStructure, Long> {

}
