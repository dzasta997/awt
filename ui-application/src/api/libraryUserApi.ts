import api from './api';

export const getAllLibraryUsers = async () => {
  try {
    const response = await api.get('/users');
    return response.data;
  } catch (error) {
    console.error('Error fetching library users:', error);
    throw error;
  }
};

export const getLibraryUserById = async (id: number) => {
  try {
    const response = await api.get(`/users/${id}`);
    return response.data;
  } catch (error) {
    console.error(`Error fetching library user with ID ${id}:`, error);
    throw error;
  }
};

export const postLibraryUser = async (libraryUser: any) => {
  try {
    const response = await api.post('/users', libraryUser);
    return response.data;
  } catch (error) {
    console.error('Error posting library user:', error);
    throw error;
  }
};

export const deleteLibraryUser = async (id: number) => {
  try {
    const response = await api.delete(`/users/${id}`);
    return response.status;
  } catch (error) {
    console.error(`Error deleting library user with ID ${id}:`, error);
    throw error;
  }
};
