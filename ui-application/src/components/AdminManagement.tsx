import React, { useState, useEffect, FormEvent } from 'react';
import {
  LibraryUserDTO,
  BookDTO,
  NewBookDTO,
  Author,
  Category,
  RentalDTO,
  CopyDTO,
} from '../api/types';
import { getAllLibraryUsers, deleteLibraryUser } from '../api/libraryUserApi';
import { getAllBooks, deleteBook, postBook } from '../api/bookApi';
import { getAllRentals } from '../api/rentalApi';
import '../sass/main.scss';
import axios from '../api/api';
import {
  getAllCategories,
  postCategory,
  deleteCategory,
} from '../api/categoryApi';
import { getAllAuthors, postAuthor } from '../api/authorApi';
import { LoginResponse } from '../services/authService';

interface AdminManagementProps {
  isAdmin: boolean;
  currentUser?: LoginResponse | null;
}

const AdminManagement: React.FC<AdminManagementProps> = ({
  isAdmin,
  currentUser,
}) => {
  const [users, setUsers] = useState<LibraryUserDTO[]>([]);
  const [books, setBooks] = useState<BookDTO[]>([]);
  const [newBook, setNewBook] = useState<NewBookDTO>({
    title: '',
    description: '',
    authors: [],
    categories: [],
  });
  const [authors, setAuthors] = useState<Author[]>([]);
  const [categories, setCategories] = useState<Category[]>([]);
  const [rentals, setRentals] = useState<RentalDTO[]>([]);

  useEffect(() => {
    if (isAdmin) {
      getAllLibraryUsers().then(setUsers);
    }
    getAllBooks().then(setBooks);
    getAllAuthors().then(setAuthors);
    getAllCategories().then(setCategories);
    getAllRentals().then(setRentals);
  }, [isAdmin]);

  const role = localStorage.getItem('role');

  const handleDeleteUser = async (userId: number) => {
    if (!isAdmin) return;
    try {
      await deleteLibraryUser(userId);
      setUsers(users.filter((user) => user.id !== userId));
    } catch (error) {
      console.error('Failed to delete user', error);
    }
  };

  const handleDeleteBook = async (bookId: number) => {
    try {
      await deleteBook(bookId);
      setBooks(books.filter((book) => book.bookId !== bookId));
    } catch (error) {
      console.error('Failed to delete book', error);
    }
  };

  const handleAddBook = async (event: FormEvent) => {
    event.preventDefault();
    try {
      const addedAuthors = await Promise.all(
        newBook.authors.map((author) => postAuthor(author))
      );
      const addedCategories = await Promise.all(
        newBook.categories.map((category) => postCategory(category))
      );

      const book: NewBookDTO = {
        ...newBook,
        authors: addedAuthors,
        categories: addedCategories,
      };

      const addedBook = await postBook(book);
      setBooks([...books, addedBook]);
      setNewBook({
        title: '',
        description: '',
        authors: [],
        categories: [],
      });
    } catch (error) {
      console.error('Failed to add book', error);
    }
  };

  return (
    <div className='admin-management'>
      {isAdmin && (
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
      )}

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

      {isAdmin && (
        <div className='admin-management__rental-section'>
          <h1 className='rental-management__title'>Rental Management</h1>
          {rentals.map((rental) => (
            <div className='rental' key={rental.rentalId}>
              <p className='rental__user'>{rental.libraryUser.username}</p>
              <p className='rental__book'>{rental.copy.book.title}</p>
              <p className='rental__from'> Borrowing date: {rental.rentalDate}</p>
              <p className='rental__to'> Due: {rental.dueDate}</p>
              {currentUser && currentUser.isAdmin && (
                <p className='rental__borrower'>
                  Borrowed by: {rental.libraryUser.username}
                </p>
              )}
            </div>
          ))}
        </div>
      )}

      {isAdmin && (
        <div className='admin-management__add-category-section'>
          {/* Add Category section */}
        </div>
      )}

      {isAdmin && (
        <div className='admin-management__add-author-section'>
          {/* Add Author section */}
        </div>
      )}

      {isAdmin && (
        <div className='admin-management__add-book-section'>
          {/* Add Book section */}
        </div>
      )}
    </div>
  );
};

export default AdminManagement;
