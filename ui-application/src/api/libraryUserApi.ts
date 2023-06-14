import api from './api'
import { LibraryUserDTO } from './types';

// Get All Users
export const getAllLibraryUsers = async () => {
  const response = await api.get<LibraryUserDTO[]>(`/users`);
  return response.data;
};

export const getLibraryUser = async (id: number, token: string | null) => {
  const response = await api.get<LibraryUserDTO>(`/users/${id}`, {
    headers: { Authorization: `Bearer ${token}` },
  });
  return response.data;
};

export const postLibraryUser = async (user: LibraryUserDTO, token: string | null) => {
  await api.post(`/users`, user, {
    headers: { Authorization: `Bearer ${token}` },
  });
};

export const deleteLibraryUser = async (id: number, token: string | null) => {
  await api.delete(`/users/${id}`, {
    headers: { Authorization: `Bearer ${token}` },
  });
};
