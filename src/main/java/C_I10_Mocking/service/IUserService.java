package C_I10_Mocking.service;

public interface IUserService {
    boolean validateUser(String name, String age);
    void addUser(String name, String age) throws Exception;
}
