package com.techspine.diamond.repository;

import com.techspine.diamond.entity.ColorMaster;
import com.techspine.diamond.projection.ColorProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<ColorMaster, Long> {

    @Query(value = """
        SELECT
            c.id as id,
            c.color as color
        FROM color_master c
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(c.color) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM color_master c
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(c.color) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            nativeQuery = true)
    Page<ColorProjection> findAllColors(@Param("search") String search, Pageable pageable);
}
