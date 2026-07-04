package com.techspine.diamond.repository;

import com.techspine.diamond.entity.FluorescenceMaster;
import com.techspine.diamond.projection.FluorescenceProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FluorescenceRepository extends JpaRepository<FluorescenceMaster, Long> {

    @Query(value = """
        SELECT
            f.id as id,
            f.fluorescence as fluorescence
        FROM fluorescence_master f
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(f.fluorescence) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM fluorescence_master f
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(f.fluorescence) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            nativeQuery = true)
    Page<FluorescenceProjection> findAllFluorescences(@Param("search") String search, Pageable pageable);
}
