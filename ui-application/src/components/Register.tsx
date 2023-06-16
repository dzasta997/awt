import '../sass/main.scss';
import picture from '../SvgContainer/picture--register.svg';
import { postLibraryUser } from '../api/libraryUserApi';
import { LibraryUserDTO } from '../api/types';
import { useState } from 'react';

const Register: React.FC<{ onClose: () => void }> = ({ onClose }) => {
  const [form, setForm] = useState<LibraryUserDTO>({
    username: '', // Add the username field here
    password: '',
    repeatPassword: '',
    firstName: '',
    lastName: '',
    email: '',
    address: {
      street: '',
      number: '',
      city: '',
      zipcode: '',
    },
    phoneNumber: '',
  });

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setForm((prevForm: LibraryUserDTO) => ({ ...prevForm, [name]: value }));
  };

  const handleAddressChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setForm((prevForm: LibraryUserDTO) => ({
      ...prevForm,
      address: {
        ...prevForm.address,
        [name]: value,
      },
    }));
  };

  const handleRegister = async () => {
    if (form.password !== form.repeatPassword) {
      alert('Passwords do not match.');
      return;
    }

    try {
      const userToRegister: LibraryUserDTO = {
        username: form.username,
        password: form.password,
        repeatPassword: form.repeatPassword,
        firstName: form.firstName,
        lastName: form.lastName,
        email: form.email,
        phoneNumber: form.phoneNumber,
        address: {
          street: form.address.street,
          number: form.address.number,
          city: form.address.city,
          zipcode: form.address.zipcode,
        },
      };

      await postLibraryUser(userToRegister);
      console.log('User registered:', form.username);
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
              id='username'
              name='username'
              className='register__input register__input--username'
              placeholder='Username'
              required
              value={form.username}
              onChange={handleInputChange}
            />

            <input
              type='text'
              id='firstName'
              name='firstName'
              className='register__input register__input--name'
              placeholder='First Name'
              required
              value={form.firstName}
              onChange={handleInputChange}
            />
            <input
              type='text'
              id='lastName'
              name='lastName'
              className='register__input register__input--surname'
              placeholder='Last Name'
              required
              value={form.lastName}
              onChange={handleInputChange}
            />
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
          </div>

          <div className='register__column register__column--address'>
            <input
              type='text'
              id='number'
              name='number'
              className='register__input register__input--number'
              placeholder='Number'
              required
              value={form.address.number}
              onChange={handleAddressChange}
            />
            <input
              type='text'
              id='city'
              name='city'
              className='register__input register__input--city'
              placeholder='City'
              required
              value={form.address.city}
              onChange={handleAddressChange}
            />
            <input
              type='text'
              id='zipcode'
              name='zipcode'
              className='register__input register__input--zipcode'
              placeholder='Zip Code'
              required
              value={form.address.zipcode}
              onChange={handleAddressChange}
            />
          </div>

          <div className='register__column'>
            <input
              type='password'
              id='password'
              name='password'
              className='register__input register__input--password'
              placeholder='Password'
              required
              value={form.password}
              onChange={handleInputChange}
            />
            <input
              type='password'
              id='repeatPassword'
              name='repeatPassword'
              className='register__input register__input--repeat-password'
              placeholder='Repeat Password'
              required
              value={form.repeatPassword}
              onChange={handleInputChange}
            />
            <input
              type='text'
              id='street'
              name='street'
              className='register__input register__input--street'
              placeholder='Street'
              required
              value={form.address.street}
              onChange={handleAddressChange}
            />

            <input
              type='text'
              id='phoneNumber'
              name='phoneNumber'
              className='register__input register__input--phone'
              placeholder='Phone Number'
              required
              value={form.phoneNumber}
              onChange={handleInputChange}
            />
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
