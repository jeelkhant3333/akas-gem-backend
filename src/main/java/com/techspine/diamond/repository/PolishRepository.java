package com.techspine.diamond.repository;

import com.techspine.diamond.entity.PolishMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolishRepository extends JpaRepository<PolishMaster,Long> {
}
