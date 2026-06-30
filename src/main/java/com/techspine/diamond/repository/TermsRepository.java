package com.techspine.diamond.repository;

import com.techspine.diamond.entity.TermsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsRepository extends JpaRepository<TermsMaster, Long> {
}
