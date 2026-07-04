package com.techspine.diamond.repository;

import com.techspine.diamond.entity.LabMaster;
import com.techspine.diamond.projection.LabProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LabRepository extends JpaRepository<LabMaster, Long> {

    @Query(value = """
        SELECT
            l.id as id,
            l.lab_name as labName
        FROM lab_master l
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(l.lab_name) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM lab_master l
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(l.lab_name) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            nativeQuery = true)
    Page<LabProjection> findAllLabs(@Param("search") String search, Pageable pageable);
}
