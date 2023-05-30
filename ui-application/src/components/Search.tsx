import React, { useState } from 'react';
import '../sass/main.scss';
import { BookDTO } from '../api/types';
import searchIcon from '../SvgContainer/search.svg';
import filterIcon from '../SvgContainer/ion_filter-sharp.svg';
import { searchBooks } from '../api/bookApi';
import { log } from 'console';

interface SearchProps {
  onSearch: (books: BookDTO[]) => void;
}

const Search: React.FC<SearchProps> = ({ onSearch }) => {
  const [searchFields, setSearchFields] = useState({
    title: null,
    category: null,
    author: null,
    firstName: null,
    lastName: null,
  });

  const [filterActive, setFilterActive] = useState(false);

  const handleSearch = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log("Form has been submitted"); // Add this line
    try {
      const books: BookDTO[] = await searchBooks(searchFields);
      console.log('Search Results:', books)
      onSearch(books);
    } catch (error) {
      console.error('Search failed', error);
    }
  };

  const handleFieldChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSearchFields({
      ...searchFields,
      [event.target.name]: event.target.value,
    });
  };

  const handleFilterClick = () => {
    setFilterActive(!filterActive);
  };

  return (
    <form
      action='#'
      className={`search ${filterActive ? 'filter-active' : ''}`}
      onSubmit={handleSearch}
    >
      <input
        type='text'
        name='title'
        className='search__input'
        placeholder='Title...'
        onChange={handleFieldChange}
      />
      <button type="submit" className='search__button'>
        <img src={searchIcon} alt='searchIcon' className='search__icon' />
      </button>
      <button
        className={`search__filter-button ${filterActive ? 'active' : ''}`}
        onClick={handleFilterClick}
      >
        <img src={filterIcon} alt='filterIcon' className='search__icon' />
      </button>
      {filterActive && (
        <div className='search__filter-content'>
          <input
            type='text'
            name='category'
            className='search__filter-input'
            placeholder='Category...'
            onChange={handleFieldChange}
          />
          <input
            type='text'
            name='author'
            className='search__filter-input'
            placeholder='Author...'
            onChange={handleFieldChange}
          />
          <input
            type='text'
            name='firstName'
            className='search__filter-input'
            placeholder='First name...'
            onChange={handleFieldChange}
          />
          <input
            type='text'
            name='lastName'
            className='search__filter-input'
            placeholder='Last name...'
            onChange={handleFieldChange}
          />
        </div>
      )}
    </form>
  );
};

export default Search;
