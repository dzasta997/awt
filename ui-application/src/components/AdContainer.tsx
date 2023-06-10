import React, { useState } from 'react';
import '../sass/main.scss';
import bookPicture1 from '../SvgContainer/book.png';

const AdContainer: React.FC = () => {
  const [isRegisterVisible, setIsRegisterVisible] = useState(false);

  const handleButtonClick = () => {
    setIsRegisterVisible(!isRegisterVisible);
  };

  // Define an array of books with their details
  const books = [
    {
      title: 'The Lord of the Rings',
      author: 'J.R.R. Tolkien',
      genre: 'Fantasy',
      image: bookPicture1,
    },
    {
      title: 'The Hitchhikers Guide to Galaxy',
      author: 'Douglas Adams',
      genre: 'Science Fiction',
      image: bookPicture1,
    },
    {
      title: 'Pride and Prejudice',
      author: 'Jane Austen',
      genre: 'Romance',
      image: bookPicture1,
    },
    {
      title: 'The Da Vinci Code',
      author: 'Dan Brown',
      genre: 'Thriller',
      image: bookPicture1,
    },
  ];

  return (
    <div className='ad-container'>
      <h1 className='ad-container__header'>
        Feeling lost? Check out the popular ones!
      </h1>
      {/* Map over the books array and render each book as an item */}
      {books.map((book) => (
        <div className='ad-container__item'>
          <img src={book.image} alt='Book cover' className='book-cover' />
          <div className='book-details'>
            <h2 className='book-title'>{book.title}</h2>
            <p className='book-author'>by {book.author}</p>
            <p className='book-genre'>{book.genre}</p>
          </div>
        </div>
      ))}
    </div>
  );
};

export default AdContainer;
