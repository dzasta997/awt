import axios from '../api/api';

const API_BASE_URL = 'http://localhost:8080';

// Define the username and password
const username = 'admin';
const password = 'pass';

// Encode the credentials
const encodedCredentials = window.btoa(`${username}:${password}`);

// Create a function that returns the header with the encoded credentials
const getAuthHeader = () => {
  // Get the encoded credentials from the localStorage
  const encodedCredentials = localStorage.getItem('authdata');

  // Return the header object
  return {
    Authorization: `Basic ${encodedCredentials}`,
  };
};

export const getAllAuthors = async () => {
  // Use the getAuthHeader function to get the header
  const headers = getAuthHeader();

  // Pass the headers to the axios request
  const response = await axios.get(`${API_BASE_URL}/authors`, { headers });
  return response.data;
};

export const getAuthor = async (id: number) => {
  // Use the getAuthHeader function to get the header
  const headers = getAuthHeader();

  // Pass the headers to the axios request
  const response = await axios.get(`${API_BASE_URL}/authors/${id}`, {
    headers,
  });
  return response.data;
};

export const postAuthor = async (author: any) => {
  // Use the getAuthHeader function to get the header
  const headers = getAuthHeader();

  // Pass the headers to the axios request
  const response = await axios.post(`${API_BASE_URL}/authors`, author, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
  return response.data;
};

export const deleteAuthor = async (id: number) => {
  // Use the getAuthHeader function to get the header
  const headers = getAuthHeader();

  // Pass the headers to the axios request
  await axios.delete(`${API_BASE_URL}/authors/${id}`, { headers });
};
