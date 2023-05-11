import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

export const getAllRentals = async () => {
  const response = await axios.get(`${API_BASE_URL}/rentals`);
  return response.data;
};

export const getRental = async (id: number) => {
  const response = await axios.get(`${API_BASE_URL}/rentals/${id}`);
  return response.data;
};

export const postRental = async (rental: any) => {
  const response = await axios.post(`${API_BASE_URL}/rentals`, rental);
  return response.data;
};

export const deleteRental = async (id: number) => {
  await axios.delete(`${API_BASE_URL}/rentals/${id}`);
};
