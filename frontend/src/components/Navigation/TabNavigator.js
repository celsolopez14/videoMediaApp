import { View, Text } from 'react-native'
import React from 'react'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import { AntDesign } from '@expo/vector-icons';
import HomeScreen from '../../screens/HomeScreen';
import ProfileScreen from '../../screens/ProfileScreen';
import SearchScreen from '../../screens/SearchScreen';
import Logo from '../Logo';

const Tab = createBottomTabNavigator();

export default function TabNavigator() {
  return (
    <Tab.Navigator initialRouteName='Home'
    screenOptions={{
        tabBarStyle: {backgroundColor:'black', borderTopWidth:0},
        headerStyle: {backgroundColor:'black'},
        headerShadowVisible:false,
        headerTitle: () => <Logo/>
    }}
    >
        <Tab.Screen
        name='Home'
        component={HomeScreen}
        options={{
            tabBarIcon:({color, size}) =>(
                <AntDesign name="home" size={35} color="green" />
            ),
        }}
        />

        <Tab.Screen
        name='Search'
        component={SearchScreen}
        options={{
            tabBarIcon:({color, size}) =>(
                <AntDesign name="search1" size={35} color="green" />
            ),
        }}
        />

        <Tab.Screen
        name='Profile'
        component={ProfileScreen}
        options={{
            tabBarIcon:({color, size}) =>(
                <AntDesign name="user" size={35} color="green" />
            ),
        }}
        />

    </Tab.Navigator>
  )
}