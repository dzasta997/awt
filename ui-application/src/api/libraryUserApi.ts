import axios from '../api/api';
import { LibraryUserDTO } from './types';

const API_BASE_URL = 'http://localhost:8080';

// Get All Users
export const getAllLibraryUsers = async () => {
  const { data } = await axios.get<LibraryUserDTO[]>(`${API_BASE_URL}/users`);
  return data;
};

// Get User by Id
export const getLibraryUser = async (id: number) => {
  const { data } = await axios.get<LibraryUserDTO>(`${API_BASE_URL}/users/${id}`);
  return data;
};

// Create User
export const postLibraryUser = async (user: LibraryUserDTO) => {
  await axios.post<LibraryUserDTO>(`${API_BASE_URL}/users`, user);
};

// Delete User
export const deleteLibraryUser = async (id: number) => {
  await axios.delete(`${API_BASE_URL}/users/${id}`);
};

// Get Current User
export const getCurrentUsername = async () => {
  const { data } = await axios.get<string>(`${API_BASE_URL}/users/user`);
  return data;
};


