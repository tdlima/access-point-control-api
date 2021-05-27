package com.lima.accesspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lima.accesspoint.model.PointMarking;

@Repository
public interface PointMarkingRepository extends JpaRepository<PointMarking, Long> {

}
