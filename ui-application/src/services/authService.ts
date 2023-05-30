// api.ts
import api from '../api/api'
import axios, { AxiosError } from 'axios';

export const login = async (username: string, password: string) => {
  try {
    const encodedCredentials = window.btoa(`${username}:${password}`);

    const response = await api.get('/login', {
      headers: {
        'Authorization': `Basic ${encodedCredentials}`
      }
    });
    
    if (response.status === 200) {
      const { data } = response;

      if (data) {
        // save user data to localStorage
        localStorage.setItem('user', JSON.stringify(`${username}:${password}`));
      }

      return data;
    }

    throw new Error('Error logging in');
  } catch (error) {
    console.error(error);
    const axiosError = error as AxiosError;
    if (axiosError.response && axiosError.response.status === 401) {
      throw new Error('Incorrect username or password');
    } else {
      throw new Error('Error logging in');
    }
  }
};
