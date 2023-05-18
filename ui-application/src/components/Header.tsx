import React, { useState } from 'react';
import '../sass/main.scss';
import logo from '../SvgContainer/logo.svg';
import searchIcon from '../SvgContainer/search.svg';
import { BookDTO } from '../api/types';
import { searchBooks } from '../api/bookApi';

const Header: React.FC<{
  onButtonClick: () => void;
  onRegisterClick: () => void;
  onSearch: (books: BookDTO[]) => void;
}> = ({ onButtonClick, onRegisterClick, onSearch }) => {
  const [searchText, setSearchText] = useState('');

  const handleSearch = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const books = await searchBooks(
      searchText,
      searchText,
      searchText,
      searchText
    );
    onSearch(books);
  };

  return (
    <header className='header'>
      <div className='header__logo-container'>
        <img src={logo} alt='Logo' className='logo' />
        <h1 className='header__name'>
          Library Management
          <br />
          System
        </h1>
      </div>
      <form action='#' className='search' onSubmit={handleSearch}>
        <input
          type='text'
          className='search__input'
          placeholder='Search...'
          onChange={(event) => setSearchText(event.target.value)}
        />
        <button className='search__button'>
          <img src={searchIcon} alt='searchIcon' />
        </button>
      </form>
      <nav className='user-nav'>
        <button className='user-nav__register' onClick={onRegisterClick}>
          Register
        </button>
        <button className='user-nav__sign-up' onClick={onButtonClick}>
          Log in
        </button>
      </nav>
    </header>
  );
};

export default Header;
