import api from './api';
import { LibraryUserDTO } from './types';

const username = 'admin';
const password = 'pass';
const encodedCredentials = window.btoa(`${username}:${password}`);

// Get All Users
export const getAllLibraryUsers = async () => {
  const response = await api.get<LibraryUserDTO[]>('/users', {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
  return response.data;
};

export const getLibraryUser = async (id: number) => {
  const response = await api.get<LibraryUserDTO>(`/users/${id}`, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
  return response.data;
};

export const postLibraryUser = async (user: LibraryUserDTO) => {
  await api.post('/users', user, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
};

export const deleteLibraryUser = async (id: number) => {
  await api.delete(`/users/${id}`, {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  });
};
