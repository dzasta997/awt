package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.repository.CopyRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CopyService {
    private final CopyRepository copyRepository;

    @Autowired
    public CopyService(final CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }
}
