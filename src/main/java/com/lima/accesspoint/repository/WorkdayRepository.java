package com.lima.accesspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lima.accesspoint.model.Workday;

@Repository
public interface WorkdayRepository extends JpaRepository<Workday, Long>{

}
