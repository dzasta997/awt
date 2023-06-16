import React from 'react';
import AdminManagement from './AdminManagement';
import UserManagement from './UserManagement';
import { LoginResponse } from '../services/authService';

interface DashboardProps {
  userName: string; // The user name prop
  currentUser: LoginResponse | null; // The currentUser prop
}

const Dashboard: React.FC<DashboardProps> = ({ userName, currentUser }) => {
  // Define a state variable to store the current component
  const [currentComponent, setCurrentComponent] =
    React.useState<React.ReactNode>(null);

  // Define a function to handle the click event on the links
  const handleClick = (component: React.ReactNode) => {
    // Set the current component to the one passed as an argument
    setCurrentComponent(component);
  };

  return (
    <div className='dashboard'>
      {userName === 'admin' ? ( // If the user name is admin, show the admin link
        <a
          href='#'
          className='dashboard__link dashboard__link--admin'
          onClick={() => handleClick(<AdminManagement isAdmin={true} />)} // Pass isAdmin prop as true
        >
          Go to Admin Management
        </a>
      ) : (
        // Otherwise, show the user link
        <a
          href='#'
          className='dashboard__link dashboard__link--user'
          onClick={() =>
            handleClick(<UserManagement currentUser={currentUser} />)
          } // Pass currentUser prop to UserManagement
        >
          Go to User Management
        </a>
      )}
      {currentComponent}
    </div>
  );
};

export default Dashboard;
