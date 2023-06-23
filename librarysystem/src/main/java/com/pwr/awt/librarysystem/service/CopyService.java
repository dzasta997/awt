package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Copy;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.CopyRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyService {
    private final CopyRepository copyRepository;

    @Autowired
    public CopyService(final CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }

    public List<Copy> findAll() {
        return copyRepository.findAll();
    }

    public Copy findByCopyId(long id) {
        return copyRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(long id){
        if(!copyRepository.existsById(id)){
            throw new OperationException();
        }
        copyRepository.deleteById(id);
    }
    public Copy saveCopy(Copy copy) {
        if (copy.getCopyId() != null && copyRepository.existsById(copy.getCopyId())) {
            throw new OperationException();
        }
        return copyRepository.save(copy);
    }

    public Copy findByBookIdAndRented(long id) {
        return copyRepository.findFirstByBook_BookIdAndRented(id, false).orElseThrow(NotFoundException::new);
    }

}
