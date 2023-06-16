import axios from '../api/api';
import { BookDTO } from './types';

const API_BASE_URL = 'http://localhost:8080';

export const getAllBooks = async () => {
  const response = await axios.get(`${API_BASE_URL}/books`);
  return response.data;
};

export const getBook = async (id: number) => {
  const response = await axios.get(`${API_BASE_URL}/books/${id}`);
  return response.data;
};

export const postBook = async (book: any) => {
  const response = await axios.post(`${API_BASE_URL}/books`, book);
  return response.data;
};

export const deleteBook = async (id: number) => {
  await axios.delete(`${API_BASE_URL}/books/${id}`);
};

export interface SearchParams {
  firstName: null;
  lastName: null;
  category: null;
  title: null;
}

export const searchBooks = async (params: SearchParams) => {
  console.log('API request is about to be made with these parameters:', params);

  try {
    const response = await axios.get(`${API_BASE_URL}/books/search`, {
      params,
    });
    console.log('API request was made. The response is:', response);

    return response.data;
  } catch (error) {
    console.error('Failed to search books', error);
    throw error;
  }
};
