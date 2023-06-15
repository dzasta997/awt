import React, { useEffect, useState } from 'react';
import { getAllBooks, getBook, deleteBook } from '../api/bookApi';
import { getAllCopies, getCopy, deleteCopy, postCopy } from '../api/copyApi';
import { BookDTO } from '../api/types';
import Search from './Search';
import SearchResults from './SearchResults';

interface Book extends BookDTO {
  isFetching: boolean;
}

interface Copy {
  id: number;
  name: string;
  // ...
}

const UserManagement: React.FC = () => {
  const [books, setBooks] = useState<Book[]>([]);
  const [copies, setCopies] = useState<Copy[]>([]);

  useEffect(() => {
    loadBooks();
    loadCopies();
  }, []);

  const loadBooks = async () => {
    const booksData = await getAllBooks();
    const mappedBooks: Book[] = booksData.map((book: BookDTO) => ({ ...book, isFetching: false }));
    setBooks(mappedBooks);
  };
  

  const loadCopies = async () => {
    const copies = await getAllCopies();
    setCopies(copies);
  };

  const handleViewBook = async (id: number) => {
    const book = books.find((book) => book.bookId === id);
    if (book && !book.isFetching) {
      book.isFetching = true;
      const bookDetails = await getBook(id);
      book.isFetching = false;
      // Do something with bookDetails
    }
  };

  const handleDeleteBook = async (id: number) => {
    await deleteBook(id);
    setBooks(books.filter((book) => book.bookId !== id));
  };
  

  const handleViewCopy = async (id: number) => {
    const copyDetails = await getCopy(id);
    // Do something with copyDetails
  };

  const handleDeleteCopy = async (id: number) => {
    await deleteCopy(id);
    setCopies(copies.filter((copy) => copy.id !== id));
  };

  const handleBorrowBook = async (bookId: string) => {
    try {
      // Create a copy with the borrowed book ID
      const copy = await postCopy({ bookId });

      // Update the copies state
      setCopies((prevCopies) => [...prevCopies, copy]);
    } catch (error) {
      console.error('Failed to borrow book', error);
      // Handle the error, show a notification, etc.
    }
  };

  return (
    <div>
      <h2>Your Books</h2>
      {books.map((book) => (
        <div key={book.bookId}>
          <h3>{book.title}</h3>
          <button onClick={() => handleViewBook(book.bookId)}>
            View Details
          </button>
          <button onClick={() => handleDeleteBook(book.bookId)}>
            Delete
          </button>
        </div>
      ))}

      <h2>Your Copies</h2>
      {copies.map((copy) => (
        <div key={copy.id}>
          <h3>{copy.name}</h3>
          <button onClick={() => handleViewCopy(copy.id)}>
            View Details
          </button>
          <button onClick={() => handleDeleteCopy(copy.id)}>
            Delete
          </button>
        </div>
      ))}

      <h2>Search Results</h2>
      <SearchResults books={books} onBorrowBook={handleBorrowBook} />
    </div>
  );
};

export default UserManagement;
