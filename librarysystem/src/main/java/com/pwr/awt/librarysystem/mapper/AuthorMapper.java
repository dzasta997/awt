package com.pwr.awt.librarysystem.mapper;

import com.pwr.awt.librarysystem.dto.AuthorDTO;
import com.pwr.awt.librarysystem.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper extends ApplicationMapper<Author, AuthorDTO> {

    @Override
    public Author toEntity(final AuthorDTO authorDTO) {
        if(authorDTO==null){
            return null;
        }
        return new Author()
                .setAuthorId(authorDTO.getAuthorId())
                .setFirstName(authorDTO.getFirstName())
                .setLastName(authorDTO.getLastName())
                .setDescription(authorDTO.getDescription());
    }

    @Override
    public AuthorDTO toDto(final Author author) {
        if(author==null){
            return null;
        }
        return new AuthorDTO()
                .setAuthorId(author.getAuthorId())
                .setFirstName(author.getFirstName())
                .setLastName(author.getLastName())
                .setDescription(author.getDescription());
    }
}
