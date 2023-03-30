package com.pwr.awt.librarysystem.mapper;

import com.pwr.awt.librarysystem.dto.BookDTO;
import com.pwr.awt.librarysystem.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper extends ApplicationMapper<Book, BookDTO> {

    private final CategoryMapper categoryMapper;
    private final AuthorMapper authorMapper;

    @Autowired
    public BookMapper(final CategoryMapper categoryMapper, final AuthorMapper authorMapper) {
        this.categoryMapper = categoryMapper;
        this.authorMapper = authorMapper;
    }

    @Override
    public Book toEntity(final BookDTO bookDTO) {
        if (bookDTO==null) {
            return null;
        }
        return new Book()
                .setBookId(bookDTO.getBookId())
                .setTitle(bookDTO.getTitle())
                .setAuthors(authorMapper.toEntity(bookDTO.getAuthors()))
                .setCategories(categoryMapper.toEntity(bookDTO.getCategories()))
                .setDescription(bookDTO.getDescription());
    }

    @Override
    public BookDTO toDto(final Book book) {
        if(book==null) {
            return null;
        }
        return new BookDTO()
                .setBookId(book.getBookId())
                .setTitle(book.getTitle())
                .setAuthors(authorMapper.toDto(book.getAuthors()))
                .setCategories(categoryMapper.toDto(book.getCategories()))
                .setDescription(book.getDescription());
    }
}
