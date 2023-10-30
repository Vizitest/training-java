package C_I10_Mocking.repository;

import C_I10_Mocking.models.User;

public interface IUpdateUserRepository {

    User execute(User user);
}
