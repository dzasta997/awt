import React, { useState } from 'react';
import './sass/main.scss';
import Header from './components/Header';
import AdContainer from './components/AdContainer';
import Login from './components/Login';
import Register from './components/Register';
import { BookDTO } from './api/types';
import SearchResults from './components/SearchResults';

const App: React.FC = () => {
  const [isLogInvisible, setLogInvisible] = useState(false);
  const [isRegisterVisible, setIsRegisterVisible] = useState(false);
  const [searchResults, setSearchResults] = useState<BookDTO[]>([]);
  const [hasSearched, setHasSearched] = useState(false);

  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [userName, setUserName] = useState('');

  const handleButtonClick = () => {
    setLogInvisible(!isLogInvisible);
  };

  const toggleRegisterModal = () => {
    setIsRegisterVisible(!isRegisterVisible);
  };

  const handleLoginSuccess = (name: string) => {
    setUserName(name);
    setIsAuthenticated(true);
    setLogInvisible(false);
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
          onSearch={(books) => {
            setSearchResults(books);
            setHasSearched(true);
          }}
          isAuthenticated={isAuthenticated}
          userName={userName}
        />
        {hasSearched ? (
          searchResults.length > 0 ? (
            // Use the SearchResults component and pass an id prop to it
            <SearchResults books={searchResults} id='app__search-results' />
          ) : (
            <p>No search results found.</p>
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
