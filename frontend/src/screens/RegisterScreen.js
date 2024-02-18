import React, { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet } from 'react-native';
import { useAuth } from '../context/AuthContext';
import { setEnabled } from 'react-native/Libraries/Performance/Systrace';


const RegisterScreen = ({ navigation }) => {
  const { login } = useAuth();
  const [frstname, setFrstname] = useState('');
  const [lstname, setLstname] = useState('');
  const [uname, setUname] = useState('');
  const [pssword, setPssword] = useState('');

  const handleRegister = async () => {
    // Implement your registration logic here
    // Example: Call an API to create a new user account
    // If registration is successful, call the login function

    try{
    const response = await fetch('http://10.0.0.130:8080/user/register',{
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      firstName: frstname,
      lastName: lstname,
      username: uname,
      password: pssword,
    }),
  });
  if(!response.ok){
    throw new Error(`HTTP error! Status: ${response.status}`);
  }

  const token = response.headers.get("Authorization");
  login(token);


} catch(error){
  console.error(error.message);
}
  };

  return (
    <View style={styles.container}>
      <Text style={styles.heading}>Register</Text>
      <TextInput
        style={styles.input}
        placeholder="First Name"
        value={frstname}
        onChangeText={(text) => setFrstname(text)}
      />
      <TextInput
        style={styles.input}
        placeholder="Last Name"
        value={lstname}
        onChangeText={(text) => setLstname(text)}
      />
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
      <Button title="Register" onPress={handleRegister} />
      <Text style={styles.loginLink} onPress={() => navigation.navigate('Login')}>
        Already have an account? Login here.
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
  loginLink: {
    marginTop: 20,
    color: 'blue',
  },
});

export default RegisterScreen;
