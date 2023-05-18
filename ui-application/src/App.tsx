import React, { useState } from 'react';
import './sass/main.scss';
import Header from './components/Header';
import AdContainer from './components/AdContainer';
import Login from './components/Login';
import Register from './components/Register';
import { BookDTO } from './api/types';

const App: React.FC = () => {
  const [isLogInvisible, setLogInvisible] = useState(false);
  const [isRegisterVisible, setIsRegisterVisible] = useState(false);
  const [searchResults, setSearchResults] = useState<BookDTO[]>([]);

  const handleButtonClick = () => {
    setLogInvisible(!isLogInvisible);
  };

  const toggleRegisterModal = () => {
    setIsRegisterVisible(!isRegisterVisible);
  };

  const handleSearch = (books: BookDTO[]) => {  // Add this function
    setSearchResults(books);
  };

  return (
    <>
      <div
        className={`app ${isLogInvisible || isRegisterVisible ? 'app--blurred' : ''}`}
      >
        <Header onButtonClick={handleButtonClick} onRegisterClick={toggleRegisterModal} onSearch={handleSearch} /> {/* Pass handleSearch to onSearch */}
        <AdContainer />
      </div>
      {isLogInvisible && <Login onClose={handleButtonClick} />}
      {isRegisterVisible && <Register onClose={toggleRegisterModal} />}
    </>
  );
};

export default App;
