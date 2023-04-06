import React from 'react';
import '../sass/main.scss';
import picture from '../SvgContainer/picture--login.svg';

const Login: React.FC<{ onClose: () => void }> = ({ onClose }) => {
  return (
    <div className='login'>
      <div className='login__background'></div>
      <div className='login__content'>
        <img src={picture} alt='picture' className='login--picture' />
        <div className='login__box'>
          <form className='login__form'>
            <input className='login__box__input' type='email' id='email' name='email' placeholder='example@mail.com' required />
            <label htmlFor='email' className="login__box__label">Email</label>
            <input className='login__box__input' type='password' id='password' name='password' placeholder='************' required />
            <label htmlFor='password' className="login__box__label">Password</label>
            <button className='login__box__button' type='submit'>Log in</button>
          </form>
        </div>
      </div>
      <button className='login__close' onClick={onClose}>
        Close
      </button>
    </div>
  );
};

export default Login;
