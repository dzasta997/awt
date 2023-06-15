import React from 'react';
import { BookDTO } from '../api/types';
import '../sass/main.scss';
import { postRental } from '../api/rentalApi';

interface SearchResultsProps {
  books: BookDTO[];
  onBorrowBook: (bookId: string) => void;
}


const SearchResults: React.FC<SearchResultsProps> = ({ books, onBorrowBook }) => {
  const handleBorrow = (bookId: string) => {
    onBorrowBook(bookId);
  };

  return (
    <div className='search-results'>
      {books.map((book) => (
        <div key={book.bookId} className='search-results__item'>
          <div className='search-results__content'>
            <div
              className='search-results__title'
              role='heading'
              aria-level={2}
            >
              {book.title}
            </div>
            <div
              className='search-results__author array-section'
              role='paragraph'
            >
              {book.authors.map((author, index) => (
                <div key={index}>
                  Author: {author.firstName} {author.lastName}
                </div>
              ))}
            </div>
            <div
              className='search-results__category array-section'
              role='paragraph'
            >
              {book.categories.map((category, index) => (
                <div key={index}>Category: {category.name}</div>
              ))}
            </div>
            <div className='search-results__description' role='paragraph'>
              Description: {book.description}
            </div>
          </div>
          <button
            className='search-results__borrow-button'
            onClick={() => handleBorrow(book.bookId.toString())}
            style={{ backgroundColor: 'var(--color-primary)' }}
          >
            Borrow book
          </button>
        </div>
      ))}
    </div>
  );
};

export default SearchResults;

