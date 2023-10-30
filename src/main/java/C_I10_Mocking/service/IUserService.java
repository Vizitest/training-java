package C_I10_Mocking.service;

import C_I10_Mocking.models.User;

public interface IUserService {
    boolean validateUser(String name, int age);
    void addUser(String name, int age) throws Exception;
    void updateCanDriveCar(String userId);
    User getUser(String userId);
}
