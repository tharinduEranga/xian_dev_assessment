package com.xian.assessment.repository;

import com.xian.assessment.model.dto.CartonNameDTO;
import com.xian.assessment.model.entity.Carton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartonRepository extends JpaRepository<Carton, Long> {
    @Query(value = "SELECT new com.xian.assessment.model.dto.CartonNameDTO(c.id, c.name) " +
            "FROM Carton c GROUP BY c.id ")
    List<CartonNameDTO> getCartonNames();
}
