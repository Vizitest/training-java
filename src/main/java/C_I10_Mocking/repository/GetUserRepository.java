package C_I10_Mocking.repository;

import C_I10_Mocking.models.User;

public class GetUserRepository implements IGetUserRepository {

    @Override
    public User execute(String userId) {
        // We'll just return some user data
        User dummyData = new User("John Brook", 35, "A great composer.");
        return dummyData;
    }

}
