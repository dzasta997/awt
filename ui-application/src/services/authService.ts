// api.ts
import api from '../api/api'
import axios, { AxiosError } from 'axios';

export const login = async (username: string, password: string) => {
  try {
    // encode the username and password in base64 format
    const encodedCredentials = window.btoa(`${username}:${password}`);

    // send a GET request to the /login endpoint with the encoded credentials as the authorization header
    const response = await api.get('/login', {
      headers: {
        'Authorization': `Basic ${encodedCredentials}`
      }
    });
    
    // check if the response status is 200 (OK)
    if (response.status === 200) {
      const { data } = response;

      if (data) {
        // save user data to localStorage
        localStorage.setItem('user', JSON.stringify(`${username}:${password}`));
      }

      // return the data from the response
      return data;
    }

    // throw an error if the response status is not 200
    throw new Error('Error logging in');
    
  } catch (error) {
    // log the error to the console
    console.error(error);
    // cast the error as an AxiosError type
    const axiosError = error as AxiosError;
    // check if the error has a response and the status is 401 (Unauthorized)
    if (axiosError.response && axiosError.response.status === 401) {
      // throw an error with a custom message
      throw new Error('Incorrect username or password');
    } else {
      // throw an error with a generic message
      throw new Error('Error logging in');
    }
  }
};
