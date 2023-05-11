import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

export const getAllCopies = async () => {
  const response = await axios.get(`${API_BASE_URL}/copies`);
  return response.data;
};

export const getCopy = async (id: number) => {
  const response = await axios.get(`${API_BASE_URL}/copies/${id}`);
  return response.data;
};

export const postCopy = async (copy: any) => {
  const response = await axios.post(`${API_BASE_URL}/copies`, copy);
  return response.data;
};

export const deleteCopy = async (id: number) => {
  await axios.delete(`${API_BASE_URL}/copies/${id}`);
};
