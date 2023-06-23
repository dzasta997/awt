// Dashboard.jsx
import React from 'react';
import AdminManagement from './AdminManagement';
import UserManagement from './UserManagement';
import { LoginResponse } from '../services/authService';

interface DashboardProps {
  userName: string;
  currentUser: LoginResponse | null;
  isUserManagementVisible: boolean;
  setIsUserManagementVisible: (value: boolean) => void;
}

const Dashboard: React.FC<DashboardProps> = ({
  userName,
  currentUser,
  isUserManagementVisible,
  setIsUserManagementVisible,
}) => {
  const handleLinkClick = () => {
    setIsUserManagementVisible(true);
  };

  return (
    <div className='dashboard'>
      {userName === 'admin' ? (
        <a
          href='#'
          className='dashboard__link dashboard__link--admin'
          onClick={handleLinkClick}
        >
          Go to Admin Management
        </a>
      ) : (
        <a
          href='#'
          className='dashboard__link dashboard__link--user'
          onClick={handleLinkClick}
        >
          Go to User Management
        </a>
      )}
      {isUserManagementVisible ? (
        <UserManagement currentUser={currentUser} />
      ) : null}
    </div>
  );
};

export default Dashboard;
