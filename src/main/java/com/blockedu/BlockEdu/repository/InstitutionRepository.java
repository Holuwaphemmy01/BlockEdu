package com.blockedu.BlockEdu.repository;

import com.blockedu.BlockEdu.data.models.Institution;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, UUID> {

    Optional<Institution> findByName(String name);

    Optional<Institution> findByOfficialPhone(String officialPhone);

    Optional<Institution> findByOfficialMail(String officialMail);

}


