import { View, Text, FlatList, StyleSheet } from 'react-native'
import React from 'react'
import VideoListItem from '../components/VideoListItem';
import { useAuth } from '../context/AuthContext';
import Loading from '../components/Loading';


export default function HomeScreen() {
  const {saveUser, user, token, saveUserFollowersAndFollowing} = useAuth();
  const [loading, setLoading] = React.useState(true);

  const [data, setData] = React.useState([]);

React.useEffect(() =>{
  const fetchData = async () => {
    try {
      const response = await fetch(`http://10.0.0.130:8080/user`,{
        method:'GET',
        headers:{
          Authorization: token,
          'Content-type': 'application/json'
        }
      });
      if(!response.ok){
        throw new Error(`HTTP error! Status: ${response.status}`)
      }
      
      const data = await response.text()
      saveUser(JSON.parse(data));
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  setLoading(true);

  fetchData();

},[]);

React.useEffect(() =>{
  
  const fetchData = async () => {
    try {
      const response = await fetch(`http://10.0.0.130:8080/${user.username}/following-videos`,{
        method:'GET',
        headers:{
          Authorization: token,
          'Content-type': 'application/json'
        }
      });
      const result = await response.text();
      setData(JSON.parse(result));
    } catch (error) {
      console.error('Error fetching data:', error);
    }
    setLoading(false);
  };

  const fetchFollowersAndFollowing = async () => {
    try {
      const response = await fetch(`http://10.0.0.130:8080/user/${user.username}/followers-and-following`,{
        method:'GET',
        headers:{
          Authorization: token,
          'Content-type': 'application/json'
        }
      });
      const result = await response.text();
      saveUserFollowersAndFollowing(JSON.parse(result));
    } catch (error) {
      console.error('Error fetching data:', error);
    }
    setLoading(false);

  }

  if(user && user.username){
    fetchFollowersAndFollowing();
    fetchData(); 
  }

},[user]);


  return ( 
    <View style={styles.container}>
      {loading ? <Loading/> :
        <FlatList
        data = {data}
        renderItem={({item}) => <VideoListItem item={item}/>}
        keyExtractor={item => item.video.id}
        />}
    </View>
  );
}
const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor:'white',
      justifyContent:'center',
    },
  });