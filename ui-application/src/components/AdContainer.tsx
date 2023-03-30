import React from 'react';
import '../sass/main.scss';

const AdContainer: React.FC = () => {
  return (
    <div >
      <h1 className="ad-header">Feeling lost? Check out the popular ones!</h1>
      <div className="adContainer">
        <div className="container__item--1">Container</div>
        <div className="container__item--2">Container</div>
        <div className="container__item--3">Container</div>
        <div className="container__item--4">Container</div>
      </div>
    </div>
  );
};

export default AdContainer;


