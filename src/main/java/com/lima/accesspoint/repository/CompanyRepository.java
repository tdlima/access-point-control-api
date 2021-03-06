package com.lima.accesspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lima.accesspoint.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
