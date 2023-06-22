import axios from '../api/api';

const API_BASE_URL = 'http://localhost:8080';

// Define the username and password
const username = 'admin';
const password = 'pass';

// Encode the credentials
const encodedCredentials = window.btoa(`${username}:${password}`);

export const getAllRentals = async () => {
  // Pass the authorization header
  const response = await axios.get(`${API_BASE_URL}/rentals/all`, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
  return response.data;
};

export const getRental = async (id: number) => {
  // Pass the authorization header
  const response = await axios.get(`${API_BASE_URL}/rentals/${id}`, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
  return response.data;
};

export const postRental = async (rental: any) => {
  // Pass the authorization header
  const response = await axios.post(`${API_BASE_URL}/rentals`, rental, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
  return response.data;
};

export const deleteRental = async (id: number) => {
  // Pass the authorization header
  await axios.delete(`${API_BASE_URL}/rentals/${id}`, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
};
