package C_I10_Mocking.repository;

import C_I10_Mocking.models.User;

public class AddUserRepository implements IAddUserRepository {

    @Override
    public void execute(User user) throws Exception {
        // Simulates adding a user to a database
        return;
    }

}
