import React, { useState, useEffect } from 'react';
import { LibraryUserDTO, BookDTO } from '../api/types';
import { getAllLibraryUsers, deleteLibraryUser } from '../api/libraryUserApi';
import { getAllBooks, deleteBook } from '../api/bookApi';
import '../sass/main.scss';

const AdminManagement: React.FC = () => {
  const [users, setUsers] = useState<LibraryUserDTO[]>([]);
  const [books, setBooks] = useState<BookDTO[]>([]);

  // Fetch users and books from API
  useEffect(() => {
    getAllLibraryUsers().then(setUsers);
    getAllBooks().then(setBooks);
  }, []);

  // Handle delete user
  const handleDeleteUser = async (userId: number) => {
    try {
      await deleteLibraryUser(userId);
      // Remove the user from the local state
      setUsers(users.filter((user) => user.id !== userId));
    } catch (error) {
      console.error('Failed to delete user', error);
    }
  };

  // Handle delete book
  const handleDeleteBook = async (bookId: number) => {
    try {
      await deleteBook(bookId);
      // Remove the book from the local state
      setBooks(books.filter((book) => book.bookId !== bookId));
    } catch (error) {
      console.error('Failed to delete book', error);
    }
  };

  // Replace with actual UI implementation
  return (
    <div className='admin-management'>
      <div className='admin-management__user-section'>
        <h1 className='user-management__title'>User Management</h1>
        {users.map((user) => (
          <div className='user' key={user.id}>
            <p className='user__name'>{user.username}</p>
            <button
              className='user__delete-button'
              onClick={() => handleDeleteUser(user.id!)}
            >
              Delete
            </button>
          </div>
        ))}
      </div>

      <div className='admin-management__book-section'>
        <h1 className='book-management__title'>Book Management</h1>
        {books.map((book) => (
          <div className='book' key={book.bookId}>
            <p className='book__title'>{book.title}</p>
            <button
              className='book__delete-button'
              onClick={() => handleDeleteBook(book.bookId)}
            >
              Delete
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default AdminManagement;
