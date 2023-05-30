import React from 'react';
import { BookDTO } from '../api/types';
import '../sass/main.scss';

// Define an interface for the props of the component
interface SearchResultsProps {
  books: BookDTO[]; // The array of books
  id?: string; // The optional id for the component
}

// Use the interface for the props type
const SearchResults: React.FC<SearchResultsProps> = ({ books, id }) => {
  const handleBorrow = (bookId: string) => {
    // Do something with the bookId, such as calling an API or updating the state
    console.log(`Borrowing book with id ${bookId}`);
  };

  return (
    <div id={id}>
      {books.map((book) => (
        <div key={book.bookId} className='item'>
          <div className='content'>
            <div className='title' role='heading' aria-level={2}>
              {book.title}
            </div>
            <div className='author' role='paragraph'>
              {book.authors.map((author, index) => (
                <div key={index}>
                  {author.firstName} {author.lastName}
                </div>
              ))}
            </div>
            <div className='category' role='paragraph'>
              {book.categories.map((category, index) => (
                <div key={index}>
                  {category.name}
                </div>
              ))}
            </div>
            <div className='description' role='paragraph'>
              {book.description}
            </div>
          </div>
          <button
            className='borrow-button'
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
