package com.techspine.diamond.repository;

import com.techspine.diamond.entity.LocationMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationMaster, Long> {
}
