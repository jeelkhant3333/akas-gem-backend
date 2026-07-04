package com.techspine.diamond.repository;

import com.techspine.diamond.entity.LocationMaster;
import com.techspine.diamond.projection.LocationProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationMaster, Long> {

    @Query(value = """
        SELECT
            l.id as id,
            l.location as location
        FROM location_master l
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(l.location) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM location_master l
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(l.location) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            nativeQuery = true)
    Page<LocationProjection> findAllLocations(@Param("search") String search, Pageable pageable);
}
