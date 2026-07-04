package com.techspine.diamond.repository;

import com.techspine.diamond.entity.PolishMaster;
import com.techspine.diamond.projection.PolishProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PolishRepository extends JpaRepository<PolishMaster, Long> {

    @Query(value = """
        SELECT
            p.id as id,
            p.polish as polish
        FROM polish_master p
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(p.polish) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM polish_master p
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(p.polish) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            nativeQuery = true)
    Page<PolishProjection> findAllPolishes(@Param("search") String search, Pageable pageable);
}
