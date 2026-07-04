package com.techspine.diamond.repository;

import com.techspine.diamond.entity.SymmetryMaster;
import com.techspine.diamond.projection.SymmetryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SymmetryRepository extends JpaRepository<SymmetryMaster, Long> {

    @Query(value = """
        SELECT
            s.id as id,
            s.symmetry as symmetry
        FROM symmetry_master s
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(s.symmetry) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM symmetry_master s
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(s.symmetry) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            nativeQuery = true)
    Page<SymmetryProjection> findAllSymmetries(@Param("search") String search, Pageable pageable);
}
