import { View, Text, FlatList, StyleSheet } from 'react-native'
import React from 'react'
import VideoListItem from '../components/VideoListItem';

const DATA = [
    {'id':'1', 'url':"https://www.youtube.com/embed/nIekqreVbWY?si=gE29zFdtHxRCxDiz", 'username':'lola', 'likes':'30'},
    {'id':'2', 'url':"https://www.youtube.com/embed/qJAaQu-DMJ0?si=LlhwMOt23gYckI8e", 'username':'lola', 'likes':'40'},
    {'id':'3', 'url':"https://www.youtube.com/embed/GZHVHK1OxC0?si=rcz1z2DXTc-O_ifx", 'username':'lola', 'likes':'60'},
    {'id':'4', 'url':"https://www.youtube.com/embed/9i1gQ7w2V24?si=Dw1VL7Hf8GYpRq3J", 'username':'lola4', 'likes':'80'},
    {'id':'5', 'url':"https://www.youtube.com/embed/pKv5MAm2Wuw?si=nO0z0bLkTejCdz_U", 'username':'lola5', 'likes':'120'},
    {'id':'6', 'url':"https://www.youtube.com/embed/zVN3XJ-jse8?si=w11oy1OhoRj7NtEp", 'username':'lola6', 'likes':'2'},
]

//DATA variable will be changed with a API fetch

export default function HomeScreen() {
  return (
    <View style={styles.container}>
        <FlatList
        data = {DATA}
        renderItem={({item}) => <VideoListItem item={item}/>}
        keyExtractor={item => item.id}
        />
    </View>
  );
}
const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: 'black',

    },
  });