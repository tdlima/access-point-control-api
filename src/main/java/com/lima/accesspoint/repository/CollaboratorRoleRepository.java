package com.lima.accesspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lima.accesspoint.model.CollaboratorRole;

@Repository
public interface CollaboratorRoleRepository extends JpaRepository<CollaboratorRole, Long> {

}
