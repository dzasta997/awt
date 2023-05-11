import React from 'react';
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080'; // Replace this with your Spring Boot application's URL and port

const instance = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

export default instance;

