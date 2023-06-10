import React, { useState } from 'react';
import '../sass/main.scss';
import logo from '../SvgContainer/logo.svg';
import Search from './Search';
import { BookDTO } from '../api/types';
import userIcon from '../SvgContainer/healthicons_ui-user-profile.svg';

interface HeaderProps {
  onButtonClick: () => void;
  onRegisterClick: () => void;
  onSearch: (books: BookDTO[]) => void; // Add the onSearch prop
  isAuthenticated: boolean;
  userName: string;
}

const Header: React.FC<HeaderProps> = ({
  onButtonClick,
  onRegisterClick,
  isAuthenticated,
  onSearch,
  userName,
}) => {
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
      <Search onSearch={onSearch} />
      <nav className='user-nav'>
        {isAuthenticated ? (
          <>
            <img src={userIcon} alt='User Icon' className='user-nav__icon' />
            <p className='user-nav__userName'>
              Hello {userName},<br />
              what should we do today?
            </p>
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
