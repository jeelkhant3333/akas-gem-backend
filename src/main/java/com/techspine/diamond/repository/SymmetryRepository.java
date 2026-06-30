package com.techspine.diamond.repository;

import com.techspine.diamond.entity.SymmetryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymmetryRepository extends JpaRepository<SymmetryMaster, Long> {
}
