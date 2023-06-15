import React, { useEffect, useState } from 'react';
import './sass/main.scss';
import Header from './components/Header';
import AdContainer from './components/AdContainer';
import Login from './components/Login';
import Register from './components/Register';
import { BookDTO } from './api/types';
import SearchResults from './components/SearchResults';
import NoResults from './components/NoResults';
import AdminManagement from './components/AdminManagement';
import { LoginResponse } from './services/authService';

const App: React.FC = () => {
  const [isLogInvisible, setLogInvisible] = useState(false);
  const [isRegisterVisible, setIsRegisterVisible] = useState(false);
  const [searchResults, setSearchResults] = useState<BookDTO[]>([]);
  const [hasSearched, setHasSearched] = useState(false);
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [userName, setUserName] = useState('');
  const [isAdmin, setIsAdmin] = useState(false);

  const handleButtonClick = () => {
    setLogInvisible(!isLogInvisible);
  };

  const toggleRegisterModal = () => {
    setIsRegisterVisible(!isRegisterVisible);
  };

  const handleLoginSuccess = (loginResponse: LoginResponse) => {
    setUserName(loginResponse.username);
    setIsAuthenticated(true);
    setIsAdmin(loginResponse.isAdmin);
    setLogInvisible(false);
  };


  const handleSearch = (books: BookDTO[]) => {
    setSearchResults(books);
    setHasSearched(true);
    console.log('Is it working even');
  };

  const handleBorrowBook = (bookId: string) => {
    // Implement the logic for borrowing the book
    console.log(`Borrowing book with ID: ${bookId}`);
  };
  
  

  return (
    <>
      <div
        className={`app ${
          isLogInvisible || isRegisterVisible ? 'app--blurred' : ''
        }`}
      >
        <Header
          onButtonClick={handleButtonClick}
          onRegisterClick={toggleRegisterModal}
          onSearch={handleSearch}
          isAuthenticated={isAuthenticated}
          userName={userName}
        />
        {isAuthenticated ? (
          <AdminManagement  isAdmin={isAdmin} />
        ) : hasSearched ? (
          searchResults.length > 0 ? (
            <SearchResults books={searchResults} onBorrowBook={handleBorrowBook} />
          ) : (
            <NoResults />
          )
        ) : (
          <AdContainer />
        )}
      </div>
      {isLogInvisible && (
        <Login
          onClose={handleButtonClick}
          onLoginSuccess={handleLoginSuccess}
        />
      )}
      {isRegisterVisible && <Register onClose={toggleRegisterModal} />}
    </>
  );
};

export default App;
