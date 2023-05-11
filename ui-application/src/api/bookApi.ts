import axios from 'axios';

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