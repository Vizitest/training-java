package C_I10_Mocking.service;

import C_I10_Mocking.models.User;
import C_I10_Mocking.repository.IAddUserRepository;


public class UserService implements IUserService {

    private final IAddUserRepository addUserRepository;

    public UserService(IAddUserRepository addUserRepository) {
        this.addUserRepository = addUserRepository;
    }

    public boolean validateUser(String name, String age) {
        int numAge = Integer.parseInt(age);
        if(name.length() < 4) return false;
        if(numAge < 18 || numAge > 120) return false;
        return true;
    }

    public void addUser(String name, String age) throws Exception {
        if(!validateUser(name, age)) throw new Exception("Illegal argument somewhere or other");
        User user = new User(name, Integer.parseInt(age));
        user.setBio("No bio available");
        addUserRepository.execute(user);
    }

}
