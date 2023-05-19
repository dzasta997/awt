import React, { useState } from 'react';
import '../sass/main.scss';
import logo from '../SvgContainer/logo.svg';
import searchIcon from '../SvgContainer/search.svg';
import { BookDTO } from '../api/types';
import { searchBooks } from '../api/bookApi';
import profilePhoto from '../SvgContainer/healthicons_ui-user-profile.svg';

interface HeaderProps {
  onButtonClick: () => void;
  onRegisterClick: () => void;
  onSearch: (books: BookDTO[]) => void;
  isAuthenticated: boolean;
  userName: string;
}

const Header: React.FC<HeaderProps> = ({
  onButtonClick,
  onRegisterClick,
  onSearch,
  isAuthenticated,
  userName,
}) => {
  const [searchText, setSearchText] = useState('');

  const handleSearch = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const books = await searchBooks(searchText);
    onSearch(books);
  };

  const handleLogoClick = () => {
    window.location.assign('/');
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
        {isAuthenticated ? (
          <>
            <img src={profilePhoto} alt='Profile' />
            <p>Hello, {userName}. What do you want to do today?</p>
          </>
        ) : (
          <>
            <button className='user-nav__register' onClick={onRegisterClick}>
              Register
            </button>
            <button className='user-nav__sign-up' onClick={onButtonClick}>
              Log in
            </button>
          </>
        )}
      </nav>
    </header>
  );
};

export default Header;
