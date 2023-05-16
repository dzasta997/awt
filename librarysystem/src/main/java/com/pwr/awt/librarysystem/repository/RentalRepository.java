package com.pwr.awt.librarysystem.repository;

import com.pwr.awt.librarysystem.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    public List<Rental> findByLibraryUser_Username(String username);
    public List<Rental> findByReturnDateIsNullAndLibraryUser_Username(String username);
}
