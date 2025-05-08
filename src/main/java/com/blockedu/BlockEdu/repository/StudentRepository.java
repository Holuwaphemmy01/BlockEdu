package com.blockedu.BlockEdu.repository;

import com.blockedu.BlockEdu.data.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    Optional<Student> findByEmail(String email);

    Optional<Student> findByStudentId(String studentId);

   // Optional<Student> findById(String studentId);
}
