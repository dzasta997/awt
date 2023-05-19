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

  // Use the id prop for the component div element
  return (
    <div id={id}>
      {books.map((book) => (
        // Use a div element with a class name of item for each book
        <div key={book.bookId} className='item'>
          {/* Wrap the title and description in a container */}
          <div className='content'>
            <div className='title' role='heading' aria-level={2}>
              {book.title}
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
