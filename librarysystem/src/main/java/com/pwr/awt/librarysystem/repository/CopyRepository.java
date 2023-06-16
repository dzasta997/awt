package com.pwr.awt.librarysystem.repository;

import com.pwr.awt.librarysystem.entity.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Long> {
    Optional<Copy> findFirstByBook_BookIdAndRented(long bookId, boolean rented);
}
