package com.techspine.diamond.repository;

import com.techspine.diamond.entity.PaymentStatusMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatusMaster, Long> {
}
