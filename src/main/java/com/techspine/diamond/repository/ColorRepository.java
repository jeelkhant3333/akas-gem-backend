package com.techspine.diamond.repository;

import com.techspine.diamond.entity.ColorMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<ColorMaster, Long> {
}
