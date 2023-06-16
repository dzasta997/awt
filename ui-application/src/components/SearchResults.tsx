import React from 'react';
import { BookDTO } from '../api/types';
import '../sass/main.scss';
import { postRental } from '../api/rentalApi';
import { LoginResponse } from '../services/authService';

interface SearchResultsProps {
  books: BookDTO[];
  onBorrowBook: (bookId: string) => void;
  currentUser: LoginResponse | null;
}

const SearchResults: React.FC<SearchResultsProps> = ({
  books,
  onBorrowBook,
  currentUser,
}) => {
  const handleBorrow = async (bookId: string) => {
    try {
      const rentalData = {
        userId: currentUser, // Provide the user ID of the borrower
        bookId: bookId, // Provide the ID of the book being borrowed
        rentalDate: new Date().toISOString(), // Provide the rental date
      };

      const response = await postRental(rentalData);
      onBorrowBook(bookId);
    } catch (error) {
      console.error('Could not borrow book: ', error);
    }
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
          {currentUser && ( // Check if currentUser is not null/undefined
            <button
              className='search-results__borrow-button'
              onClick={() => handleBorrow(book.bookId.toString())}
              style={{ backgroundColor: 'var(--color-primary)' }}
            >
              Borrow book
            </button>
          )}
        </div>
      ))}
    </div>
  );
};

export default SearchResults;
