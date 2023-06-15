import axios from 'axios';

const encodedCredentials = window.btoa('admin:pass');


// Provide a default value for config if it is undefined or null
const instance = axios.create( {
  baseURL: 'http://localhost:8080', // Replace this with your server URL
  headers: {
    'Content-Type': 'application/json'
  },
});

// Intercept the request to make sure the Authorization token is injected into the header.
instance.interceptors.request.use((config) => {
  const user = JSON.parse(localStorage.getItem('user') || '{}');

  if (user && user.authdata) {
    // Provide a default value for config.headers if it is undefined or null
    config.headers = config.headers ?? {};
    config.headers['Authorization'] = 'Basic ' + user.authdata;
  }
  return config;
});

export default instance;
