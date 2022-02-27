package com.cloudcollaborators.collaboratorservice.repository;


import com.cloudcollaborators.collaboratorservice.domain.ProductTeams;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends CrudRepository<ProductTeams, Long> {
}
