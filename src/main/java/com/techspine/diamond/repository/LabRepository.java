package com.techspine.diamond.repository;

import com.techspine.diamond.entity.LabMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabRepository extends JpaRepository<LabMaster, Long> {
}
