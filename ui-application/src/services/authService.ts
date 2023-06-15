import { AxiosError } from "axios";
import api from '../api/api'

export interface LoginResponse {
  isAdmin: boolean;
  username: string;
  // Add other relevant properties as needed
}


export const login = async (username: string, password: string): Promise<LoginResponse> => {
  try {
    // Encode the username and password in base64 format
    const encodedCredentials = window.btoa(`${username}:${password}`);

    // Send a GET request to the /login endpoint with the encoded credentials as the Authorization header
    const response = await api.get('/login', {
      headers: {
        'Authorization': `Basic ${encodedCredentials}`
      }
    });

    // Check if the response status is 200 (OK)
    if (response.status === 200) {
      const { data } = response;

      if (data) {
        // Save user data to localStorage
        localStorage.setItem('user', JSON.stringify({username, isAdmin: data.isAdmin, token: data.token}));
      }

      // Return the data from the response
      return data;
    }

    // Throw an error if the response status is not 200
    throw new Error('Error logging in');
  } catch (error) {
    // Log the error to the console
    console.error(error);

    // Cast the error as an AxiosError type
    const axiosError = error as AxiosError;

    // Check if the error has a response and the status is 401 (Unauthorized)
    if (axiosError.response && axiosError.response.status === 401) {
      // Throw an error with a custom message
      throw new Error('Incorrect username or password');
    } else {
      // Throw an error with a generic message
      throw new Error('Error logging in');
    }
  }
};

export default login;
