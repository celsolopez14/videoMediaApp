import React, { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet } from 'react-native';
import { useAuth } from '../context/AuthContext';

const LoginScreen = ({ navigation }) => {
  const { login } = useAuth();
  const [uname, setUname] = useState('');
  const [pssword, setPssword] = useState('');

  const handleLogin = async () => {

    try{

    

    const response = await fetch('http://10.0.0.130:8080/auth',{
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      username: uname,
      password: pssword,
    }),
  });
  if(!response.ok){
    throw new Error(`HTTP error! Status: ${response.status}`);
  }
  const token = response.headers.get("Authorization");
  login(token);
}catch(error){
  console.log(error.message);
}
  };

  return (
    <View style={styles.container}>
      <Text style={styles.heading}>Login</Text>
      <TextInput
        style={styles.input}
        placeholder="Username"
        value={uname}
        onChangeText={(text) => setUname(text)}
      />
      <TextInput
        style={styles.input}
        placeholder="Password"
        secureTextEntry
        value={pssword}
        onChangeText={(text) => setPssword(text)}
      />
      <Button title="Login" onPress={handleLogin} />
      <Text style={styles.registerLink} onPress={() => navigation.navigate('Register')}>
        Don't have an account? Register here.
      </Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  heading: {
    fontSize: 24,
    marginBottom: 20,
  },
  input: {
    width: '80%',
    padding: 10,
    marginBottom: 20,
    borderWidth: 1,
    borderColor: '#ccc',
    borderRadius: 5,
  },
  registerLink: {
    marginTop: 20,
    color: 'blue',
  },
});

export default LoginScreen;
