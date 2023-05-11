import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

export const getAllUserInfo = async () => {
  const response = await axios.get(`${API_BASE_URL}/userinfo`);
  return response.data;
};

export const getUserInfo = async (id: number) => {
  const response = await axios.get(`${API_BASE_URL}/userinfo/${id}`);
  return response.data;
};

export const postUserInfo = async (userInfo: any) => {
  const response = await axios.post(`${API_BASE_URL}/userinfo`, userInfo);
  return response.data;
};

export const deleteUserInfo = async (id: number) => {
  await axios.delete(`${API_BASE_URL}/userinfo/${id}`);
};
