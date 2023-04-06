import React, { useState } from 'react';
import './sass/main.scss';
import Header from './components/Header';
import AdContainer from './components/AdContainer';
import Login from './components/Login';

const App: React.FC = () => {
  const [isLogInvisible, setLogInvisible] = useState(false);

  const handleButtonClick = () => {
    setLogInvisible(!isLogInvisible);
  };

  return (
    <>
      <div className={`app ${isLogInvisible ? 'app--blurred' : ''}`}>
        <Header onButtonClick={handleButtonClick} />
        <AdContainer />
      </div>
      {isLogInvisible && <Login onClose={handleButtonClick} />}
    </>
  );
};

export default App;
