import { View, Text, StyleSheet, TouchableOpacity } from 'react-native'
import React from 'react'

const UserItem = ({item}) => {
  return (
    <View style={styles.userContainer}>
    <Text style={styles.text}>{item.username}</Text>
    <TouchableOpacity style={styles.onUnfollowbutton} onPress={() => onUnfollow(item.id)}>
        <Text>Unfollow</Text>
      </TouchableOpacity>
  </View>
);
}

const styles = StyleSheet.create({
    userContainer: {
      flexDirection: 'row',
      justifyContent: 'space-between',
      alignItems: 'center',
      padding: 10,
      borderBottomWidth: 1,
      borderBottomColor: '#ccc',
    },
    text:{
      fontSize:15,
      marginRight:20
    },
    onUnfollowbutton:{
      backgroundColor: '#FF3856',
      borderRadius:15,
      padding:10
    },
    followButton:{
      backgroundColor:'#1899D6',
      borderRadius:15,
      padding:10
    }
  });

export default UserItem