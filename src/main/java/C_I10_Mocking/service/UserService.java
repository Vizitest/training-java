package C_I10_Mocking.service;

import C_I10_Mocking.models.User;
import C_I10_Mocking.repository.IAddUserRepository;
import C_I10_Mocking.repository.IGetUserRepository;
import C_I10_Mocking.repository.IUpdateUserRepository;


public class UserService implements IUserService {

    private final IGetUserRepository getUserRepository;
    private final IAddUserRepository addUserRepository;
    private final IUpdateUserRepository updateUserRepository;

    public UserService(IAddUserRepository addUserRepository, IGetUserRepository getUserRepository, IUpdateUserRepository updateUserRepository) {
        this.getUserRepository = getUserRepository;
        this.addUserRepository = addUserRepository;
        this.updateUserRepository = updateUserRepository;
    }

    public User getUser(String userId) {
        return this.getUserRepository.execute(userId);
    }

    public boolean validateUser(String name, int age) {
        if(name.length() < 4) return false;
        if(age < 18 || age > 120) return false;
        return true;
    }

    public void addUser(String name, int age) throws Exception {
        if(!validateUser(name, age)) throw new Exception("Illegal argument somewhere or other");
        User user = new User(name, age);
        user.setBio("No bio available");
        addUserRepository.execute(user);
    }

    public void updateCanDriveCar(String userId) {
        User user = getUser(userId);
        if(user.getAge() >= 18) {
            user.setCanDriveCar(true);
        }
        else {
            user.setCanDriveCar(false);
        }
        updateUserRepository.execute(user);
    }

}
