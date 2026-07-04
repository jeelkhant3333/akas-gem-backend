package com.techspine.diamond.repository;

import com.techspine.diamond.entity.CutMaster;
import com.techspine.diamond.projection.CutProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CutRepository extends JpaRepository<CutMaster, Long> {

    @Query(value = """
        SELECT
            c.id as id,
            c.cut as cut
        FROM cut_master c
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(c.cut) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM cut_master c
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(c.cut) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            nativeQuery = true)
    Page<CutProjection> findAllCuts(@Param("search") String search, Pageable pageable);
}
