import React, { createContext, useContext, useState } from 'react';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [token, setToken] = useState(null);

  const login = (jwt) => {
    // Implement login logic and set the user
    setToken(jwt);
  };

  const saveUser = (userData) =>{
    setUser(userData);
  };

  const saveUserFollowersAndFollowing = (followersAndFollowing) =>{
    setUser((prevUser) =>({
      ...prevUser,
      followers: followersAndFollowing.followers,
      following: followersAndFollowing.following
    }));
  }

  const logout = () => {
    // Implement logout logic and clear the user
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, token, login, logout, saveUser, saveUserFollowersAndFollowing }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  return useContext(AuthContext);
};
