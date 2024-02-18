package com.videomedia.videoappbackend.repository;



import java.util.Optional;



import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.videomedia.videoappbackend.pojo.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    /*
     @Autowired
    private DynamoDBMapper mapper;

    public Optional<User> save(User user){
      mapper.save(user);
      return Optional.of(user);  
    }

    public Optional<User> findById(Long userId){
        return Optional.ofNullable(mapper.load(User.class, userId));
    }

    public String deleteById(Long userId){
        mapper.delete(userId);
        return "User deleted.";
    }

    public String editUser(User user){
        mapper.save(user,buildExpression(user));
        return "User edited.";
    }

    public String saveAll(List<User> users){
        mapper.batchSave(users);
        return "Users saved";
    }

    public Set<User> getMultipleUsers(Set<Long> followersId){
        List<User> itemsToGet = new ArrayList<User>();
        for(Long id: followersId){
            User user = new User();
            user.setId(id);
            itemsToGet.add(user);
        }

        Map<String, List<Object>> users = mapper.batchLoad(itemsToGet);
        List<Object> userObjects = users.get("users");
        return userObjects.stream()
                .map(object -> (User) object)
                .collect(Collectors.toSet());
    }

    public List<User> findAll(){
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<User> users = mapper.scan(User.class, scanExpression);
        return users;
    }

   public Optional<User> findByUsername(String username){
    DynamoDBQueryExpression<User> queryExpression = new DynamoDBQueryExpression<User>()
                .withIndexName("usernameIndex")
                .withConsistentRead(false)
                .withKeyConditionExpression("username = :v_username")
                .withExpressionAttributeValues(Map.of(":v_username", new AttributeValue().withS(username)));

        PaginatedQueryList<User> queryList = mapper.query(User.class, queryExpression);
        return queryList.isEmpty() ? Optional.empty() : Optional.of(queryList.get(0));
   } 

    private DynamoDBSaveExpression buildExpression(User user){
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("userId",
                new ExpectedAttributeValue( new AttributeValue().withS(String.valueOf(user.getId()))));
        dynamoDBSaveExpression.setExpected(expectedAttributeValueMap);
        return dynamoDBSaveExpression;
         
    }
     */
}
