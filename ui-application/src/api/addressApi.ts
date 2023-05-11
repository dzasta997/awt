import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

export const getAllAddresses = async () => {
  const response = await axios.get(`${API_BASE_URL}/addresses`);
  return response.data;
};

export const getAddress = async (id: number) => {
  const response = await axios.get(`${API_BASE_URL}/addresses/${id}`);
  return response.data;
};

export const postAddress = async (address: any) => {
  const response = await axios.post(`${API_BASE_URL}/addresses`, address);
  return response.data;
};

export const deleteAddress = async (id: number) => {
  await axios.delete(`${API_BASE_URL}/addresses/${id}`);
};
