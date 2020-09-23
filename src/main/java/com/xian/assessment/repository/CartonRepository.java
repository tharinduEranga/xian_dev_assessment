package com.xian.assessment.repository;

import com.xian.assessment.model.entity.Carton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartonRepository extends JpaRepository<Carton, Long> {

}
