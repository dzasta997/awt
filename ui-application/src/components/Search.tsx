import React, { useState } from 'react';
import '../sass/main.scss';
import { BookDTO } from '../api/types';
import searchIcon from '../SvgContainer/search.svg';
import filterIcon from '../SvgContainer/ion_filter-sharp.svg';

interface SearchProps {
  onSearch: (books: BookDTO[]) => void;
}

const Search: React.FC<SearchProps> = ({ onSearch }) => {
  const [searchFields, setSearchFields] = useState({
    title: '',
    category: '',
    author: '',
    firstName: '',
    lastName: '',
  });

  const [filterActive, setFilterActive] = useState(false);

  const handleSearch = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    try {
      // Perform the search and obtain the books
      // Use the onSearch prop to pass the books to the parent component
      // Example API call: const books: BookDTO[] = await searchBooks(searchFields);
      // onSearch(books);
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
    <form action='#' className={`search ${filterActive ? 'filter-active' : ''}`} onSubmit={handleSearch}>
      <input
        type='text'
        name='title'
        className='search__input'
        placeholder='Title...'
        onChange={handleFieldChange}
      />
      <button className='search__button'>
        <img
          src={searchIcon}
          alt='searchIcon'
          className='search__icon'
        />
      </button>
      <button className={`search__filter-button ${filterActive ? 'active' : ''}`} onClick={handleFilterClick}>
        <img
          src={filterIcon}
          alt='filterIcon'
          className='search__icon'
        />
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
