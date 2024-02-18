import React from 'react';
import { View, Text, TouchableOpacity, Platform,StyleSheet, FlatList } from 'react-native';
import { RadioButton } from 'react-native-paper';
import UserItem from '../components/UserItem';
import { useAuth } from '../context/AuthContext';
import VideoListItem from '../components/VideoListItem';

const ProfileScreen = () => {
  const {user} = useAuth()
  const [checked, setChecked] = React.useState('Videos');
  const handlePress = (value) => {
    setChecked(value);
  };

  React.useEffect(() =>{
    const fetchFollowersAndFollowing = async () => {
      try {
        const response = await fetch(`http://10.0.0.130:8080/${user.username}/videos`,{
          method:'GET',
          headers:{
            Authorization: token,
            'Content-type': 'application/json'
          }
        });
        const result = await response.text();
        setVideos(result);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
      setLoading(false);
  
    }
    fetchFollowersAndFollowing();
  },[]);

  const renderRadioButton = () =>{
    if(Platform.OS === 'ios'){
      return (
        <View style={styles.radioContainer}>
          <TouchableOpacity onPress={() => handlePress('Videos')}>
            <View style={{ alignItems: 'center' }}>
              <RadioButton.IOS
                value="Videos"
                status={checked === 'Videos' ? 'checked' : 'unchecked'}
                onPress={() => handlePress('Videos')}
              />
              <Text>Videos</Text>
            </View>
          </TouchableOpacity>
    
          <TouchableOpacity onPress={() => handlePress('Following')}>
            <View style={{ alignItems: 'center' }}>
              <RadioButton.IOS
                value="Following"
                status={checked === 'Following' ? 'checked' : 'unchecked'}
                onPress={() => handlePress('Following')}
              />
              <Text>Following</Text>
            </View>
          </TouchableOpacity>
    
          <TouchableOpacity onPress={() => handlePress('Followers')}>
            <View style={{ alignItems: 'center' }}>
              <RadioButton.IOS
                value="Followers"
                status={checked === 'Followers' ? 'checked' : 'unchecked'}
                onPress={() => handlePress('Followers')}
              />
              <Text>Followers</Text>
            </View>
          </TouchableOpacity>
        </View>
      );
      
    } else if(Platform.OS === 'android'){
      return (
        <View style={styles.radioContainer}>
          <TouchableOpacity onPress={() => handlePress('Videos')}>
            <View style={{ alignItems: 'center', marginHorizontal:10  }}>
              <RadioButton.Android
                value="Videos"
                status={checked === 'Videos' ? 'checked' : 'unchecked'}
                onPress={() => handlePress('Videos')}
              />
              <Text>Videos</Text>
            </View>
          </TouchableOpacity>
    
          <TouchableOpacity onPress={() => handlePress('Following')}>
            <View style={{ alignItems: 'center', marginHorizontal:10  }}>
              <RadioButton.Android
                value="Following"
                status={checked === 'Following' ? 'checked' : 'unchecked'}
                onPress={() => handlePress('Following')}
              />
              <Text>Following</Text>
            </View>
          </TouchableOpacity>
    
          <TouchableOpacity onPress={() => handlePress('Followers')}>
            <View style={{ alignItems: 'center', marginHorizontal:10 }}>
              <RadioButton.Android
                value="Followers"
                status={checked === 'Followers' ? 'checked' : 'unchecked'}
                onPress={() => handlePress('Followers')}
              />
              <Text>Followers</Text>
            </View>
          </TouchableOpacity>
        </View>
      );
    }

  }

  const flatList = () =>{
    if(checked === 'Following'){
      return (
        <FlatList
        data = {user.following}
        renderItem={({item}) => <UserItem item={item}/>}
        keyExtractor={item => item.id}
        />
      )
    }
    if(checked === 'Followers'){
      return (
        <FlatList
        data = {user.followers}
        renderItem={({item}) => <UserItem item={item}/>}
        keyExtractor={item => item.id}
        />
      )
    }
    if(checked === 'Videos'){
      return (
        <FlatList
        data = {user.videos}
        renderItem={({item}) => <VideoListItem item={item}/>}
        keyExtractor={item => item.id}
        />
      )
    }
  }

  return (
    <View style={styles.container}>
      <View style={styles.rowContainer}>
        <Text style={styles.name}>
          {user.firstName} {user.lastName}
        </Text>
        <Text style={styles.username}>
          @{user.username}
        </Text>
        {renderRadioButton()}
        {flatList()}
    </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
  },
  rowContainer: {
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 20,
  },
  radioContainer: {
    flexDirection: 'row',
    marginHorizontal: 20,
    alignItems: 'center',
    borderWidth: 1,
    borderColor: 'black',
    padding: 20,
    borderRadius: 5,
  },
  name: {
    fontSize:20,
    fontWeight:'bold',
    padding:10,
    color:'black',
  },
  username:{
    fontSize:15,
    padding:10,
    color:'black',
  }

});

export default ProfileScreen;
