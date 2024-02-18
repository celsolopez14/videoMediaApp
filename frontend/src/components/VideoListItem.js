import { View, Text, StyleSheet } from 'react-native'
import React from 'react'
import { WebView } from 'react-native-webview';
import { SafeAreaView } from 'react-native-safe-area-context';

export default function VideoListItem({item}) {
  return (
        <View style={styles.container}>
                <WebView
            style={styles.webview}
            source={{ uri: item.video.videoUrl }}
            mediaPlaybackRequiresUserAction={true}
            scrollEnabled={false}
            
            />
            <Text style={styles.title}>{item.video.title}</Text>
            <View style={styles.textContainer}>
                <Text style={styles.text}>{item.userDTO.firstName}</Text>
                <Text style={styles.text}>*</Text>
                <Text style={styles.text}>{item.video.likes.length} Likes</Text>
            </View>
        </View>
    );
  
};

const styles = StyleSheet.create({
    container: {
      flex: 1,
      borderBottomColor:'whitesmoke',
      borderWidth:1,
    },
    webview: {
        height: 300, 
      },
      textContainer:{
        
        flexDirection:'row',
      },
      title:{
        fontSize:20,
        fontWeight:'bold',
        marginLeft:10,
        color:'black',
      },
      text:{
        fontSize:15,
        marginLeft:10,
        color:'black',
        paddingBottom:5,
      },
  });