package C_I10_Mocking.repository;

import C_I10_Mocking.models.User;

public class UpdateUserRepository implements IUpdateUserRepository {

    @Override
    public User execute(User user) {
        // Would update a user in the database
        return user;
    }

}
