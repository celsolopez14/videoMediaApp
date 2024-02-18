import React from 'react';
import TabNavigator from './TabNavigator';
import LoginStack from './StackNavigator';
import { useAuth } from '../../context/AuthContext';


const MainNavigator = () => {
    const {token} = useAuth();
  return token ? <TabNavigator/> : <LoginStack/> 
};

export default MainNavigator;