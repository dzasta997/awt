// api.ts
import axios from 'axios'

export const login = async (username: string, password: string) => {
  try {
    const encodedCredentials = window.btoa(`${username}:${password}`);

    const response = await axios.get('/login', {
      headers: {
        'Authorization': `Basic ${encodedCredentials}`
      }
    });
    
    if (response.status === 200) {
      const { data } = response;

      if (data) {
        // save user data to localStorage
        localStorage.setItem('user', JSON.stringify(data));
      }

      return data;
    }

    throw new Error('Error logging in');
  } catch (error) {
    console.error(error);
    throw error;
  }
};
