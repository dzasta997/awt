import React from 'react';
import './sass/main.scss';
import Header from './components/Header';
import AdContainer from './components/AdContainer';


function App() {
  return (
    <div className='App'>
      <Header/>
      <AdContainer />
    </div>
  );
}

export default App;
