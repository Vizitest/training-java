package C_I10_Mocking.repository;

import C_I10_Mocking.models.User;

public interface IAddUserRepository {

    void execute(User user) throws Exception;
}
