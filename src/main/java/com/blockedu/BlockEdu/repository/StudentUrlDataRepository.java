package com.blockedu.BlockEdu.repository;

import com.blockedu.BlockEdu.data.models.StudentUrlData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentUrlDataRepository extends JpaRepository<StudentUrlData, String> {

}
