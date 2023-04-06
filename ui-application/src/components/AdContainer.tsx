import React, { useState } from 'react';
import '../sass/main.scss';

const AdContainer: React.FC = () => {
  const [isRegisterVisible, setIsRegisterVisible] = useState(false);

  const handleButtonClick = () => {
    setIsRegisterVisible(!isRegisterVisible);
  };

  return (
    <div className='ad-container'>
      <h1 className='ad-container__header'>
        Feeling lost? Check out the popular ones!
      </h1>
      <div className='ad-container__item ad-container__item--1'>Container</div>
      <div className='ad-container__item ad-container__item--2'>Container</div>
      <div className='ad-container__item ad-container__item--3'>Container</div>
      <div className='ad-container__item ad-container__item--4'>Container</div>
    </div>
  );
};

export default AdContainer;
