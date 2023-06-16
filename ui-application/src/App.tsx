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
import UserManagement from './components/UserManagement';
import { LoginResponse } from './services/authService';

const App: React.FC = () => {
  const [isLogInvisible, setLogInvisible] = useState(false);
  const [isRegisterVisible, setIsRegisterVisible] = useState(false);
  const [searchResults, setSearchResults] = useState<BookDTO[]>([]);
  const [hasSearched, setHasSearched] = useState(false);
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [userName, setUserName] = useState('');
  const [isAdmin, setIsAdmin] = useState(false);
  const [isUserManagementVisible, setIsUserManagementVisible] = useState(false);
  const [currentUser, setCurrentUser] = useState<LoginResponse | null>(null);

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
    setCurrentUser(loginResponse);
  };

  const handleSearch = (books: BookDTO[]) => {
    setSearchResults(books);
    setHasSearched(true);
    console.log('Is it working even');
  };

  const handleBorrowBook = (bookId: string) => {
    const updatedSearchResults = searchResults.filter(
      (book) => book.bookId !== Number(bookId)
    );
    setSearchResults(updatedSearchResults);
    console.log(`${currentUser?.username}: borrowed this book ID: ${bookId}`);
  };

  const handleDashboardClick = () => {
    setIsUserManagementVisible(true);
    setHasSearched(false); // Hide search results when dashboard is clicked
  };

  const handleLogout = () => {
    setIsAuthenticated(false);
    setUserName('');
    setIsAdmin(false);
    setCurrentUser(null);
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
          onDashboardClick={handleDashboardClick}
          onLogout={handleLogout} // Pass the handleLogout function as a prop
        />
        {isAuthenticated ? (
          isAdmin ? (
            <AdminManagement isAdmin={isAdmin} currentUser={currentUser} />
          ) : (
            <>
              {isUserManagementVisible ? (
                <UserManagement currentUser={currentUser} />
              ) : (
                <>
                  {!hasSearched && !isUserManagementVisible ? (
                    <AdContainer />
                  ) : searchResults.length > 0 && !isUserManagementVisible ? (
                    <SearchResults
                      books={searchResults}
                      onBorrowBook={handleBorrowBook}
                      currentUser={currentUser}
                    />
                  ) : (
                    <NoResults />
                  )}
                </>
              )}
            </>
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
