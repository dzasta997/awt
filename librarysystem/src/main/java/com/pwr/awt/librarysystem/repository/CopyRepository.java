package com.pwr.awt.librarysystem.repository;

import com.pwr.awt.librarysystem.entity.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Long> {
}
