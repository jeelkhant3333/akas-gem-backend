package com.techspine.diamond.repository;

import com.techspine.diamond.entity.ClarityMaster;
import com.techspine.diamond.projection.ClarityProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClarityRepository extends JpaRepository<ClarityMaster, Long> {

    @Query(value = """
        SELECT
            c.id as id,
            c.clarity as clarity
        FROM clarity_master c
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(c.clarity) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM clarity_master c
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(c.clarity) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            nativeQuery = true)
    Page<ClarityProjection> findAllClarities(@Param("search") String search, Pageable pageable);
}
