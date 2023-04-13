import React, { useState } from 'react';
import './sass/main.scss';
import Header from './components/Header';
import AdContainer from './components/AdContainer';
import Login from './components/Login';
import Register from './components/Register';

const App: React.FC = () => {
  const [isLogInvisible, setLogInvisible] = useState(false);
  const [isRegisterVisible, setIsRegisterVisible] = useState(false);

  const handleButtonClick = () => {
    setLogInvisible(!isLogInvisible);
  };

  const toggleRegisterModal = () => {
    setIsRegisterVisible(!isRegisterVisible);
  };

  return (
    <>
      <div
        className={`app ${isLogInvisible || isRegisterVisible ? 'app--blurred' : ''}`}
      >
        <Header onButtonClick={handleButtonClick} onRegisterClick={toggleRegisterModal} />
        <AdContainer />
      </div>
      {isLogInvisible && <Login onClose={handleButtonClick} />}
      {isRegisterVisible && <Register onClose={toggleRegisterModal} />}
    </>
  );
};

export default App;
