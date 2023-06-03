package trinhquangtan.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trinhquangtan.demo.Repository.IUserRepository;
import trinhquangtan.demo.enity.User;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public void save(User user)
    {
        userRepository.save(user);
    }
}
