import React, { useState } from 'react';
import '../sass/main.scss';
import picture from '../SvgContainer/picture--register.svg';
import { postLibraryUser } from '../api/libraryUserApi';

const Register: React.FC<{ onClose: () => void }> = ({ onClose }) => {
  const [form, setForm] = useState({
    name: '',
    surname: '',
    email: '',
    password: '',
    repeatPassword: '',
    address: '',
  });

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setForm({ ...form, [name]: value });
  };

  const handleRegister = async () => {
    if (form.password !== form.repeatPassword) {
      alert('Passwords do not match.');
      return;
    }

    const libraryUser = {
      username: form.email,
      password: form.password,
      userInfo: {
        firstName: form.name,
        lastName: form.surname,
        address: form.address,
      },
    };

    try {
      const newUser = await postLibraryUser(libraryUser);
      console.log('User registered:', newUser);
      onClose();
    } catch (error) {
      console.error('Error registering user:', error);
      alert('Error registering user. Please try again.');
    }
  };

  return (
    <div className='register'>
      <div className='register__background'></div>
      <div className='register__content'>
        <div className='register__picture-container'>
          <img src={picture} alt='picture' className='login--picture' />
        </div>
        <div className='register__form-box'>
          <div className='register__column'>
            <input
              type='text'
              id='name'
              name='name'
              className='register__input register__input--name'
              placeholder='Name'
              required
              value={form.name}
              onChange={handleInputChange}
            />
            <label htmlFor='surname' className='register__label'>
              Surname
            </label>
            <input
              type='text'
              id='surname'
              name='surname'
              className='register__input register__input--surname'
              placeholder='Surname'
              required
              value={form.surname}
              onChange={handleInputChange}
            />
            <label htmlFor='name' className='register__label'>
              Name
            </label>
            <input
              type='email'
              id='email'
              name='email'
              className='register__input register__input--email'
              placeholder='example@mail.com'
              required
              value={form.email}
              onChange={handleInputChange}
            />
            <label htmlFor='email' className='register__label'>
              Email
            </label>
          </div>
          <div className='register__column'>
            <input
              type='password'
              id='password'
              name='password'
              className='register__input register__input--password'
              placeholder='password'
              required
              value={form.password}
              onChange={handleInputChange}
            />
            <label htmlFor='password' className='register__label'>
              Password
            </label>
            <input
              type='password'
              id='repeat-password'
              name='repeatPassword'
              className='register__input register__input--repeat-password'
              placeholder='repeat password'
              required
              value={form.repeatPassword}
              onChange={handleInputChange}
            />
            <label htmlFor='repeat-password' className='register__label'>
              Repeat Password
            </label>
            <input
              type='text'
              id='address'
              name='address'
              className='register__input register__input--address'
              placeholder='Address'
              required
              value={form.address}
              onChange={handleInputChange}
            />
            <label htmlFor='address' className='register__label'>
              Address
            </label>
          </div>
        </div>
        <button className='register__close' onClick={onClose}>
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
        <button
          className='register__submit'
          type='submit'
          onClick={handleRegister}
        >
          Register
        </button>
      </div>
    </div>
  );
};

export default Register;
