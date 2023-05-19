import React from 'react';
import picture from '../SvgContainer/popup_page.svg';
import '../sass/main.scss';

interface PopupProps {
  message: string;
  onClose: () => void;
}

const Popup: React.FC<PopupProps> = ({ message, onClose }) => {
  return (
    <div className="popup">
      <div className="popup__content">
        <p className="popup__message">{message}</p>
        <button className="popup__button" onClick={onClose}>Close</button>
      </div>
    </div>
  );
};

export default Popup;

