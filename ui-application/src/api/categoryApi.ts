import axios from '../api/api';

const API_BASE_URL = 'http://localhost:8080';

// Create a function that returns the header with the encoded credentials
const getAuthHeader = () => {
  // Get the encoded credentials from the localStorage
  const encodedCredentials = localStorage.getItem('authdata');

  // Return the header object
  return {
    Authorization: `Basic ${encodedCredentials}`,
  };
};

export const getAllCategories = async () => {
  // Use the getAuthHeader function to get the header
  const headers = getAuthHeader();

  // Pass the headers to the axios request
  const response = await axios.get(`${API_BASE_URL}/categories`, { headers });
  return response.data;
};

export const getCategory = async (id: number) => {
  // Use the getAuthHeader function to get the header
  const headers = getAuthHeader();

  // Pass the headers to the axios request
  const response = await axios.get(`${API_BASE_URL}/categories/${id}`, {
    headers,
  });
  return response.data;
};

export const postCategory = async (category: any) => {
  // Use the getAuthHeader function to get the header
  const headers = getAuthHeader();

  // Pass the headers to the axios request
  const response = await axios.post(`${API_BASE_URL}/categories`, category, {
    headers,
  });
  return response.data;
};

export const deleteCategory = async (id: number) => {
  // Use the getAuthHeader function to get the header
  const headers = getAuthHeader();

  // Pass the headers to the axios request
  await axios.delete(`${API_BASE_URL}/categories/${id}`, { headers });
};
