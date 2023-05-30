import React from 'react';
import noResultsIcon from '../SvgContainer/ic_outline-search-off.svg';
import '../sass/main.scss';

const NoResults: React.FC = () => (
  <div className="no-results">
    <img src={noResultsIcon} alt="No results" className="no-results__icon" />
    <h2 className="no-results__title">No search results found.</h2>
    <p className="no-results__description">Please try again with different keywords.</p>
    <button className="no-results__button">Go Back</button>
  </div>
);

export default NoResults;
