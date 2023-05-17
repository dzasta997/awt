package com.pwr.awt.librarysystem.mapper;

import com.pwr.awt.librarysystem.dto.RentalDTO;
import com.pwr.awt.librarysystem.entity.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentalMapper extends ApplicationMapper<Rental, RentalDTO> {
    private final CopyMapper copyMapper;
    private final LibraryUserMapper libraryUserMapper;

    @Autowired
    public RentalMapper(final CopyMapper copyMapper, final LibraryUserMapper libraryUserMapper) {
        this.copyMapper = copyMapper;
        this.libraryUserMapper = libraryUserMapper;
    }


    @Override
    public Rental toEntity(final RentalDTO rentalDTO) {
        if(rentalDTO==null) {
            return null;
        }
        return new Rental()
                .setRentalId(rentalDTO.getRentalId())
                .setRentalDate(rentalDTO.getRentalDate())
                .setDueDate(rentalDTO.getDueDate())
                .setReturnDate(rentalDTO.getReturnDate())
                .setStatus(rentalDTO.getStatus())
                .setCopy(copyMapper.toEntity(rentalDTO.getCopy()))
                .setLibraryUser(libraryUserMapper.toEntity(rentalDTO.getLibraryUser()));
    }

    @Override
    public RentalDTO toDto(final Rental rental) {
        if(rental==null) {
            return null;
        }
        return new RentalDTO()
                .setRentalId(rental.getRentalId())
                .setRentalDate(rental.getRentalDate())
                .setDueDate(rental.getDueDate())
                .setReturnDate(rental.getReturnDate())
                .setStatus(rental.getStatus())
                .setCopy(copyMapper.toDto(rental.getCopy()))
                .setLibraryUser(libraryUserMapper.toDto(rental.getLibraryUser()));
    }
}
