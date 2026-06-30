package com.techspine.diamond.repository;

import com.techspine.diamond.entity.ShapeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeRepository extends JpaRepository<ShapeMaster, Long> {
}
