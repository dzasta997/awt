package com.pwr.awt.librarysystem.repository;

import com.pwr.awt.librarysystem.entity.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {
    LibraryUser findByUsername(String username);
    boolean existsByUsername(String username);
}
