import axios from '../api/api';

const API_BASE_URL = 'http://localhost:8080';

// Define the username and password
const username = 'admin';
const password = 'pass';

// Encode the credentials
const encodedCredentials = window.btoa(`${username}:${password}`);

export const getAllCopies = async () => {
  // Pass the authorization header
  const response = await axios.get(`${API_BASE_URL}/copies`, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
  return response.data;
};

export const getCopy = async (id: number) => {
  // Pass the authorization header
  const response = await axios.get(`${API_BASE_URL}/copies/${id}`, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
  return response.data;
};

export const postCopy = async (copy: any) => {
  // Pass the authorization header
  const response = await axios.post(`${API_BASE_URL}/copies`, copy, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
  return response.data;
};

export const deleteCopy = async (id: number) => {
  // Pass the authorization header
  await axios.delete(`${API_BASE_URL}/copies/${id}`, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
};
