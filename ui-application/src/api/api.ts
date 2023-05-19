import axios from 'axios';


const encodedCredentials = window.btoa('admin:pass');


const instance = axios.create({
  baseURL: 'http://localhost:8080', // Replace this with your server URL
  headers: {
    'Content-Type': 'application/json',
    'Authorization': `Basic ${encodedCredentials}`
  },
});

// Intercept the request to make sure the Authorization token is injected into the header.
instance.interceptors.request.use((config) => {
  const user = JSON.parse(localStorage.getItem('user') || '{}');

  if (user && user.authdata) {
    config.headers['Authorization'] = 'Basic ' + user.authdata;
  } else {
    config.headers['Authorization'] = `Basic ${encodedCredentials}`;
  }

  return config;
});


export default instance;
