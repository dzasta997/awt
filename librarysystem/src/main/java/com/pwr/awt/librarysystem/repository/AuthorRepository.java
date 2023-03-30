package com.pwr.awt.librarysystem.repository;

import com.pwr.awt.librarysystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
