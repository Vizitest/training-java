package C_I10_Mocking.repository;

import C_I10_Mocking.models.User;

public class AddUserRepository implements IAddUserRepository {

    @Override
    public User execute(User user) throws Exception {
        // Would add a user to a database
        return user;
    }

}
