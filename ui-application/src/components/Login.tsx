import React, { useState } from 'react';
import '../sass/main.scss';
import picture from '../SvgContainer/picture--login.svg';
import { login } from '../services/authService';
import Popup from './Popup';  // import the Popup component

interface LoginProps {
  onClose: () => void;
  onLoginSuccess: (name: string) => void;  // Add this line
}

const Login: React.FC<LoginProps> = ({ onClose, onLoginSuccess }) => {
  // Add state for username and password
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');  // Add this line

  const handleSubmit = async (event: React.FormEvent) => {
    event.preventDefault();
    try {
      const data = await login(username, password);
      console.log('Login successful', data);
      // Assuming that the "name" field is returned from the "login" function
      onLoginSuccess(data); 
      onClose(); 
    } catch (error) {
      console.error('Login failed', error);
      setErrorMessage('Sorry, this account either does not exist or the password is incorrect.');
    }
  };

  const handlePopupClose = () => {
    setErrorMessage('');
  };

  return (
    <div className='login'>
      <div className='login__background'></div>
      <div className='login__content'>
        <img src={picture} alt='picture' className='login--picture' />
        <div className='login__box'>
          <form className='login__form' onSubmit={handleSubmit}>
            <div className='login__box__group'>
              <input
                className='login__box__input'
                type='text'
                id='email'
                name='email'
                placeholder='example@mail.com'
                required
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
              <label htmlFor='email' className='login__box__label'>
                Email
              </label>
              <svg
                width='24'
                height='24'
                viewBox='0 0 24 24'
                fill='none'
                xmlns='http://www.w3.org/2000/svg'
              >
                <path
                  d='M12 21V19H19V5H12V3H19C19.55 3 20.021 3.19567 20.413 3.587C20.8043 3.979 21 4.45 21 5V19C21 19.55 20.8043 20.021 20.413 20.413C20.021 20.8043 19.55 21 19 21H12ZM10 17L8.625 15.55L11.175 13H3V11H11.175L8.625 8.45L10 7L15 12L10 17Z'
                  fill='#222222'
                />
              </svg>
            </div>
            <div className='login__box__group'>
              <input
                className='login__box__input'
                type='password'
                id='password'
                name='password'
                placeholder='************'
                required
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
              <label htmlFor='password' className='login__box__label'>
                Password
              </label>
              <svg
                width='24'
                height='24'
                viewBox='0 0 24 24'
                fill='none'
                xmlns='http://www.w3.org/2000/svg'
              >
                <path
                  d='M19 13C19.34 13 19.67 13.04 20 13.09V10C20 9.46957 19.7893 8.96086 19.4142 8.58579C19.0391 8.21071 18.5304 8 18 8H17V6C17 3.24 14.76 1 12 1C9.24 1 7 3.24 7 6V8H6C5.46957 8 4.96086 8.21071 4.58579 8.58579C4.21071 8.96086 4 9.46957 4 10V20C4 21.11 4.89 22 6 22H13.81C13.3 21.12 13 20.1 13 19C13 15.69 15.69 13 19 13ZM9 6C9 4.34 10.34 3 12 3C13.66 3 15 4.34 15 6V8H9V6ZM12 17C11.6044 17 11.2178 16.8827 10.8889 16.6629C10.56 16.4432 10.3036 16.1308 10.1522 15.7654C10.0009 15.3999 9.96126 14.9978 10.0384 14.6098C10.1156 14.2219 10.3061 13.8655 10.5858 13.5858C10.8655 13.3061 11.2219 13.1156 11.6098 13.0384C11.9978 12.9613 12.3999 13.0009 12.7654 13.1522C13.1308 13.3036 13.4432 13.56 13.6629 13.8889C13.8827 14.2178 14 14.6044 14 15C14 16.11 13.11 17 12 17ZM23 18V20H15V18H23Z'
                  fill='#222222'
                />
              </svg>
            </div>
            <button className='login__box__button' type='submit'>
              Log in
            </button>
          </form>
          <button className='login__content__close' onClick={onClose}>
            <svg
              width='14'
              height='14'
              viewBox='0 0 14 14'
              fill='none'
              xmlns='http://www.w3.org/2000/svg'
            >
              <path
                d='M1.4 14L0 12.6L5.6 7L0 1.4L1.4 0L7 5.6L12.6 0L14 1.4L8.4 7L14 12.6L12.6 14L7 8.4L1.4 14Z'
                fill='#140B34'
              />
            </svg>
          </button>
        </div>
        {errorMessage && <Popup message={errorMessage} onClose={handlePopupClose} />}  {/* Add this line */}
      </div>
    </div>
  );
};

export default Login;
