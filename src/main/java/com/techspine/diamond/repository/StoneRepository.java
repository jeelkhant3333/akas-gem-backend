package com.techspine.diamond.repository;

import com.techspine.diamond.entity.Stone;
import com.techspine.diamond.projection.StoneProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface StoneRepository extends JpaRepository<Stone, Long> {

    @Query(value = """
        SELECT
            s.id as id,
            s.kapan as kapan,
            s.lot_no as lotNo,
            sm.shape_name as shape,
            s.weight_ct as weightCt,

            cm.color as color,
            clm.clarity as clarity,
            cutm.cut as cut,
            pm.polish as polish,
            sym.symmetry as symmetry,
            fm.fluorescence as fluorescence,
            lm.lab_name as lab,

            s.cert_no as certNo,

            s.per_carat as perCarat,
            s.total_carat as totalCarat,
            s.rate as rate,
            s.amount as amount,
            s.brokerage as brokerage,
            s.final_amount as finalAmount,

            psm.status as paymentStatus,
            s.sell_date as sellDate,
            s.payment_done_date as paymentDoneDate,

            loc.location as location,
            tm.terms_name as terms,

            s.party_name as partyName,
            s.broker_name as brokerName

        FROM stones s

        LEFT JOIN shape_master sm ON sm.id = s.shape_id
        LEFT JOIN color_master cm ON cm.id = s.color_id
        LEFT JOIN clarity_master clm ON clm.id = s.clarity_id
        LEFT JOIN cut_master cutm ON cutm.id = s.cut_id
        LEFT JOIN polish_master pm ON pm.id = s.polish_id
        LEFT JOIN symmetry_master sym ON sym.id = s.symmetry_id
        LEFT JOIN fluorescence_master fm ON fm.id = s.fluorescence_id
        LEFT JOIN lab_master lm ON lm.id = s.lab_id
        LEFT JOIN payment_status_master psm ON psm.id = s.payment_status_id
        LEFT JOIN location_master loc ON loc.id = s.location_id
        LEFT JOIN terms_master tm ON tm.id = s.terms_id

        WHERE
        (
            :search IS NULL
            OR :search = ''
            OR LOWER(s.kapan) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(s.lot_no) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(s.party_name) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(s.broker_name) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(s.cert_no) LIKE LOWER(CONCAT('%', :search, '%'))
        )

        AND (:shapeId IS NULL OR s.shape_id = :shapeId)
        AND (:colorId IS NULL OR s.color_id = :colorId)
        AND (:clarityId IS NULL OR s.clarity_id = :clarityId)
        AND (:cutId IS NULL OR s.cut_id = :cutId)
        AND (:polishId IS NULL OR s.polish_id = :polishId)
        AND (:symmetryId IS NULL OR s.symmetry_id = :symmetryId)
        AND (:fluorescenceId IS NULL OR s.fluorescence_id = :fluorescenceId)
        AND (:labId IS NULL OR s.lab_id = :labId)
        AND (:paymentStatusId IS NULL OR s.payment_status_id = :paymentStatusId)
        AND (:locationId IS NULL OR s.location_id = :locationId)
        AND (:termsId IS NULL OR s.terms_id = :termsId)

        AND (:fromDate IS NULL OR DATE(s.sell_date) >= :fromDate)
        AND (:toDate IS NULL OR DATE(s.sell_date) <= :toDate)
        """,
            countQuery = """
        SELECT COUNT(*)
        FROM stones s

        WHERE
        (
            :search IS NULL
            OR :search = ''
            OR LOWER(s.kapan) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(s.lot_no) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(s.party_name) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(s.broker_name) LIKE LOWER(CONCAT('%', :search, '%'))
            OR LOWER(s.cert_no) LIKE LOWER(CONCAT('%', :search, '%'))
        )

        AND (:shapeId IS NULL OR s.shape_id = :shapeId)
        AND (:colorId IS NULL OR s.color_id = :colorId)
        AND (:clarityId IS NULL OR s.clarity_id = :clarityId)
        AND (:cutId IS NULL OR s.cut_id = :cutId)
        AND (:polishId IS NULL OR s.polish_id = :polishId)
        AND (:symmetryId IS NULL OR s.symmetry_id = :symmetryId)
        AND (:fluorescenceId IS NULL OR s.fluorescence_id = :fluorescenceId)
        AND (:labId IS NULL OR s.lab_id = :labId)
        AND (:paymentStatusId IS NULL OR s.payment_status_id = :paymentStatusId)
        AND (:locationId IS NULL OR s.location_id = :locationId)
        AND (:termsId IS NULL OR s.terms_id = :termsId)
        AND (:fromDate IS NULL OR DATE(s.sell_date) >= :fromDate)
        AND (:toDate IS NULL OR DATE(s.sell_date) <= :toDate)
        """,
            nativeQuery = true)
    Page<StoneProjection> findAllStones(
            @Param("search") String search,

            @Param("shapeId") Long shapeId,
            @Param("colorId") Long colorId,
            @Param("clarityId") Long clarityId,
            @Param("cutId") Long cutId,
            @Param("polishId") Long polishId,
            @Param("symmetryId") Long symmetryId,
            @Param("fluorescenceId") Long fluorescenceId,
            @Param("labId") Long labId,
            @Param("paymentStatusId") Long paymentStatusId,
            @Param("locationId") Long locationId,
            @Param("termsId") Long termsId,

            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,

            Pageable pageable
    );
}