package com.pwr.awt.librarysystem.mapper;

import com.pwr.awt.librarysystem.dto.CopyDTO;
import com.pwr.awt.librarysystem.entity.Copy;
import org.springframework.beans.factory.annotation.Autowired;

public class CopyMapper extends ApplicationMapper<Copy, CopyDTO>{

    private final BookMapper bookMapper;

    @Autowired
    public CopyMapper(final BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Copy toEntity(final CopyDTO copyDTO) {
        if(copyDTO==null) {
            return null;
        }
            return new Copy()
                    .setCopyId(copyDTO.getCopyId())
                    .setIsbn(copyDTO.getIsbn())
                    .setPublicationYear(copyDTO.getPublicationYear())
                    .setDescription(copyDTO.getDescription())
                    .setBook(bookMapper.toEntity(copyDTO.getBook()));
    }

    @Override
    public CopyDTO toDto(final Copy copy) {
        if(copy==null) {
            return null;
        }
        return new CopyDTO()
                .setCopyId(copy.getCopyId())
                .setIsbn(copy.getIsbn())
                .setPublicationYear(copy.getPublicationYear())
                .setDescription(copy.getDescription())
                .setBook(bookMapper.toDto(copy.getBook()));
    }
}
