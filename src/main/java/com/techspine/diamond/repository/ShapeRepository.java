package com.techspine.diamond.repository;

import com.techspine.diamond.entity.ShapeMaster;
import com.techspine.diamond.projection.ShapeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeRepository extends JpaRepository<ShapeMaster, Long> {

    @Query(value = """
        SELECT
            s.id as id,
            s.shape_name as shapeName
        FROM shape_master s
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(s.shape_name) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM shape_master s
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(s.shape_name) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            nativeQuery = true)
    Page<ShapeProjection> findAllShapes(@Param("search") String search, Pageable pageable);
}
