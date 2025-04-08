package com.blockedu.BlockEdu.repository;

import com.blockedu.BlockEdu.data.models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InstitutionRepository extends JpaRepository<Institution, UUID> {

    Optional<Institution> findByEmail(String email);
}


