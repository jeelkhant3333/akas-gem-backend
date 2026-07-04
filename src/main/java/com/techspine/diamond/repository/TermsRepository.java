package com.techspine.diamond.repository;

import com.techspine.diamond.entity.TermsMaster;
import com.techspine.diamond.projection.TermsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsRepository extends JpaRepository<TermsMaster, Long> {

    @Query(value = """
        SELECT
            t.id as id,
            t.terms_name as termsName,
            t.description as description
        FROM terms_master t
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(t.terms_name) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(t.description) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM terms_master t
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(t.terms_name) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(t.description) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            nativeQuery = true)
    Page<TermsProjection> findAllTerms(@Param("search") String search, Pageable pageable);
}
