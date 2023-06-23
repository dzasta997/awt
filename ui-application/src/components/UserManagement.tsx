import React, { useEffect, useState } from 'react';
import { getUserRentals } from '../api/rentalApi';
import { RentalDTO } from '../api/types';
import '../sass/main.scss';
import { LoginResponse } from '../services/authService';

interface UserManagementProps {
  currentUser: LoginResponse | null;
}

const UserManagement: React.FC<UserManagementProps> = ({ currentUser }) => {
  const [userRentals, setUserRentals] = useState<RentalDTO[]>([]);

  useEffect(() => {
    loadRentals();
  }, []);

  const loadRentals = async () => {
    try {
      const allRentals = await getUserRentals();
      console.log('All rentals: ', allRentals); // log all rentals to check the data
      setUserRentals(allRentals);
    } catch (error) {
      console.error('Could not fetch rentals: ', error);
    }
  };

  return (
    <div className='user-management'>
      <div className='user-management__copies'>
        <h1 className='user-management__title'>Your Copies</h1>
        {userRentals.map((rental) => (
          <div className='user-management__copy' key={rental.rentalId}>
            <h2 className='user-management__copy-title'> Copy name:{rental.copy.name}</h2>
            <p className='user-management__copy-details'>
              Rental Date: {rental.rentalDate}
              <br />
              Rental ID: {rental.rentalId}
              <br />
              Status: {rental.status}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default UserManagement;
