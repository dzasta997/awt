import React, { useEffect, useState } from 'react';
import { getAllRentals, getRental } from '../api/rentalApi';
import { RentalDTO } from '../api/types';
import '../sass/main.scss';
import { LoginResponse } from '../services/authService';

interface UserManagementProps {
  currentUser: LoginResponse | null;
}

const UserManagement: React.FC<UserManagementProps> = ({ currentUser }) => {
  // Define a state variable to store the rentals for the current user
  const [userRentals, setUserRentals] = useState<RentalDTO[]>([]);


  

  useEffect(() => {
    loadRentals();
  }, []);

  const loadRentals = async () => {
    // Check if currentUser is not null/undefined
    if (currentUser) {
      // Fetch all rentals from the api
      const rentalsData = await getAllRentals();


      // Filter the rentals by the current user ID
      const userRentalsData = rentalsData.filter(
        (rental: RentalDTO) => rental.libraryUser.username === currentUser.username
      );

      // Set the user rentals state variable
      setUserRentals(userRentalsData);
    }
  };

  return (
    <div className='user-management'>
      <div className='user-management__copies'>
        <h1 className='user-management__title'>Your Copies</h1>
        {userRentals.map((rental) => (
          <div className='user-management__copy' key={rental.rentalId}>
            <h1 className='user-management__copy-title'>{rental.copy.name}</h1>
            <p className='user-management__copy-date'>
              Rental Date: {rental.rentalDate}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default UserManagement;
