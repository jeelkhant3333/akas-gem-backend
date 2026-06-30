package com.techspine.diamond.repository;

import com.techspine.diamond.entity.ClarityMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClarityRepository extends JpaRepository<ClarityMaster, Long> {
}
