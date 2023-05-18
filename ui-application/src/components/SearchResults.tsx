import React from 'react';
import { BookDTO } from '../api/types';


interface SearchResultsProps {
  books: BookDTO[]; // Replace BookDTO with the type of your book object
}

const SearchResults: React.FC<SearchResultsProps> = ({ books }) => {
  return (
    <div>
      {books.map((book) => (
        <div key={book.bookId}>
          <h2>{book.title}</h2>
          <p>{book.description}</p>
        </div>
      ))}
    </div>
  );
};

export default SearchResults;
