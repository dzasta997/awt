import api from './api';
import { LibraryUserDTO } from './types';

// Get All Users
export const getAllLibraryUsers = async () => {
  const response = await api.get<LibraryUserDTO[]>('/users');
  return response.data;
};

export const getLibraryUser = async (id: number) => {
  const response = await api.get<LibraryUserDTO>(`/users/${id}`);
  return response.data;
};

export const postLibraryUser = async (user: LibraryUserDTO) => {
  await api.post('/users', user);
};

export const deleteLibraryUser = async (id: number) => {
  await api.delete(`/users/${id}`);
};
