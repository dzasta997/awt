import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

export const getAllCategories = async () => {
  const response = await axios.get(`${API_BASE_URL}/categories`);
  return response.data;
};

export const getCategory = async (id: number) => {
  const response = await axios.get(`${API_BASE_URL}/categories/${id}`);
  return response.data;
};

export const postCategory = async (category: any) => {
  const response = await axios.post(`${API_BASE_URL}/categories`, category);
  return response.data;
};

export const deleteCategory = async (id: number) => {
  await axios.delete(`${API_BASE_URL}/categories/${id}`);
};
