import { NavigationContainer } from '@react-navigation/native';
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import TabNavigator from './components/Navigation/TabNavigator';

export default function App() {
  return (
    <NavigationContainer>
      <TabNavigator/>
    </NavigationContainer> 
  );
}

