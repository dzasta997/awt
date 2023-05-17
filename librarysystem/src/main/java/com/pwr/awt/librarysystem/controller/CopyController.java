package com.pwr.awt.librarysystem.controller;

import com.pwr.awt.librarysystem.dto.CopyDTO;
import com.pwr.awt.librarysystem.entity.Copy;
import com.pwr.awt.librarysystem.mapper.CopyMapper;
import com.pwr.awt.librarysystem.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("copies")
public class CopyController {
    private final CopyMapper categoryMapper;
    private final CopyService categoryService;

    @Autowired
    public CopyController(CopyMapper categoryMapper, CopyService categoryService) {
        this.categoryMapper = categoryMapper;
        this.categoryService = categoryService;
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public ResponseEntity<List<CopyDTO>> getAllCopies() {
        List<Copy> copies = categoryService.findAll();
        return new ResponseEntity<>(categoryMapper.toDto(copies), HttpStatus.OK);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public ResponseEntity<CopyDTO> getCopy(@PathVariable long id) {
        Copy category = categoryService.findByCopyId(id);
        return new ResponseEntity<>(categoryMapper.toDto(category), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CopyDTO> postCopy(@RequestBody CopyDTO categoryDTO) {
        Copy categorySaved = categoryService.saveCopy(categoryMapper.toEntity(categoryDTO));
        return new ResponseEntity<>(categoryMapper.toDto(categorySaved), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCopy(@PathVariable long id) {
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
