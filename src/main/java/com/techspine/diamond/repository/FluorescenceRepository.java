package com.techspine.diamond.repository;

import com.techspine.diamond.entity.FluorescenceMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FluorescenceRepository extends JpaRepository<FluorescenceMaster, Long> {
}
