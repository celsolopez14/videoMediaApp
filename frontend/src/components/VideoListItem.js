import { View, Text, StyleSheet } from 'react-native'
import React from 'react'
import { WebView } from 'react-native-webview';
import { SafeAreaView } from 'react-native-safe-area-context';

export default function VideoListItem({item}) {
  return (
        <View style={styles.container}>
                <WebView
            style={styles.webview}
            source={{ uri: item.videoUrl }}
            mediaPlaybackRequiresUserAction={true}
            
            />
            <Text style={styles.title}>Title</Text>
            <View style={styles.textContainer}>
                <Text style={styles.text}>{item.user.username}</Text>
                <Text style={styles.text}>{item.likes.length} Likes</Text>
            </View>
        </View>
    );
  
};

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: 'black',
      padding:1,
      
    },
    webview: {
        height: 200, 
      },
      textContainer:{
        
        flexDirection:'row',
      },
      title:{
        fontSize:25,
        padding:10,
        color:'whitesmoke',
      },
      text:{
        fontSize:15,
        padding:10,
        color:'whitesmoke',
        paddingBottom:5,
      },
  });