package com.pwr.awt.librarysystem.repository;

import com.pwr.awt.librarysystem.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
}
