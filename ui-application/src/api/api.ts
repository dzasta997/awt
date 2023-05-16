import axios from 'axios';


const encodedCredentials = btoa('admin@example.com:pass');


const instance = axios.create({
  baseURL: 'http://localhost:8080', // Replace this with your server URL
  headers: {
    'Content-Type': 'application/json',
    'Authentication: ': 'Basic YWRtaW5AZXhhbXBsZS5jb206cGFzcw=='
  },
});

// Intercept the request to make sure the Authorization token is injected into the header.
instance.interceptors.request.use((config) => {
  const user = JSON.parse(localStorage.getItem('user') || '{}');

  if (user && user.authdata) {
    config.headers = config.headers || {};
    config.headers['Authorization'] = 'Basic ' + user.authdata;
  }

  return config;
});

export default instance;
