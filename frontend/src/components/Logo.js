import { View, Text, Image, StyleSheet } from 'react-native'
import React from 'react'

export default function Logo() {
  return (
      <View style={style.container}>
        <Image style={style.logo}
        source={require('../assets/image0.jpeg')}
        resizeMode='contain'
        />
      </View>
    
  );
}


const style = StyleSheet.create({
    container:{
        flexDirection:'row',
        alignItems:'center',
        justifyContent:'flex-start',
        paddingLeft:10,
        maxWidth:'100%',
    },
    logo:{
        width:40,
        height:40,
    }
})