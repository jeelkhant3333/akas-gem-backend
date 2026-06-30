package com.techspine.diamond.repository;

import com.techspine.diamond.entity.CutMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CutRepository extends JpaRepository<CutMaster, Long> {
}
