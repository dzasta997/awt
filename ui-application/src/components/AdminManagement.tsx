import React, { useState, useEffect, FormEvent } from 'react';
import {
  LibraryUserDTO,
  BookDTO,
  NewBookDTO,
  Author,
  Category,
} from '../api/types';
import { getAllLibraryUsers, deleteLibraryUser } from '../api/libraryUserApi';
import { getAllBooks, deleteBook, postBook } from '../api/bookApi';
import '../sass/main.scss';
import { postCategory } from '../api/categoryApi';
import { postAuthor } from '../api/authorApi';

const AdminManagement: React.FC = () => {
  const [users, setUsers] = useState<LibraryUserDTO[]>([]);
  const [books, setBooks] = useState<BookDTO[]>([]);
  const [newBook, setNewBook] = useState<NewBookDTO>({
    title: '',
    authors: [],
    categories: [],
    description: '',
  });
  const [newAuthor, setNewAuthor] = useState<Author>({
    firstName: '',
    lastName: '',
  });
  const [newCategory, setNewCategory] = useState<Category>({ name: '' });

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

  const handleAddBook = async (event: FormEvent) => {
    event.preventDefault();
    try {
      const author = await postAuthor(newAuthor);
      const category = await postCategory(newCategory);

      const book = await postBook({
        ...newBook,
        authors: [author],
        categories: [category],
      });
      setBooks([...books, book]);
      setNewBook({ title: '', authors: [], categories: [], description: '' });
      setNewAuthor({ firstName: '', lastName: '' });
      setNewCategory({ name: '' });
    } catch (error) {
      console.error('Failed to add book', error);
    }
  };

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

      <div className='admin-management__add-book-section'>
        <h1 className='add-book__title'>Add Book</h1>
        <form className='add-book__form' onSubmit={handleAddBook}>
          <label className='add-book__label'>
            Title:
            <input
              className='add-book__input'
              type='text'
              value={newBook.title}
              onChange={(e) =>
                setNewBook({ ...newBook, title: e.target.value })
              }
              required
            />
          </label>
          <label className='add-book__label'>
            Description:
            <textarea
              className='add-book__textarea'
              value={newBook.description}
              onChange={(e) =>
                setNewBook({ ...newBook, description: e.target.value })
              }
              required
            />
          </label>

          <label className='add-book__label'>
            First Name:
            <input
              className='add-book__input'
              type='text'
              placeholder='First name'
              value={newAuthor.firstName}
              onChange={(e) =>
                setNewAuthor({ ...newAuthor, firstName: e.target.value })
              }
              required
            />
            Last Name:
            <input
              className='add-book__input'
              type='text'
              placeholder='Last name'
              value={newAuthor.lastName}
              onChange={(e) =>
                setNewAuthor({ ...newAuthor, lastName: e.target.value })
              }
              required
            />
          </label>

          <label className='add-book__label'>
            Category:
            <input
              className='add-book__input'
              type='text'
              value={newCategory.name}
              onChange={(e) => setNewCategory({ name: e.target.value })}
              required
            />
          </label>
          <button className='add-book__button' type='submit'>
            Add book
          </button>
        </form>
      </div>
    </div>
  );
};

export default AdminManagement;
