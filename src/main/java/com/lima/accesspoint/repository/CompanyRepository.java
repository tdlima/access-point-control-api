package com.lima.accesspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lima.accesspoint.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
