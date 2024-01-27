import { View, Text, FlatList, StyleSheet } from 'react-native'
import React from 'react'
import VideoListItem from '../components/VideoListItem';


export default function HomeScreen() {

  const [data, setData] = React.useState([]);
React.useEffect(() =>{
  
  const fetchData = async () => {
    try {
      const response = await fetch('http://192.168.1.171:8080/video/all');
      const result = await response.json();
      setData(result);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  fetchData();

},[]);

  return (
    <View style={styles.container}>
        <FlatList
        data = {data}
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