package com.techspine.diamond.repository;

import com.techspine.diamond.entity.PaymentStatusMaster;
import com.techspine.diamond.projection.PaymentStatusProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatusMaster, Long> {

    @Query(value = """
        SELECT
            p.id as id,
            p.status as status
        FROM payment_status_master p
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(p.status) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM payment_status_master p
        WHERE (
            :search IS NULL
            OR :search = ''
            OR LOWER(p.status) LIKE LOWER(CONCAT('%', :search, '%'))
        )
        """,
            nativeQuery = true)
    Page<PaymentStatusProjection> findAllPaymentStatuses(@Param("search") String search, Pageable pageable);
}
