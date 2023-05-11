import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

export const getAllAuthors = async () => {
  const response = await axios.get(`${API_BASE_URL}/authors`);
  return response.data;
};

export const getAuthor = async (id: number) => {
  const response = await axios.get(`${API_BASE_URL}/authors/${id}`);
  return response.data;
};

export const postAuthor = async (author: any) => {
  const response = await axios.post(`${API_BASE_URL}/authors`, author);
  return response.data;
};

export const deleteAuthor = async (id: number) => {
  await axios.delete(`${API_BASE_URL}/authors/${id}`);
};
