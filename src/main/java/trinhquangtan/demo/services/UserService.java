package trinhquangtan.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trinhquangtan.demo.Repository.IRoleRepository;
import trinhquangtan.demo.Repository.IUserRepository;
import trinhquangtan.demo.enity.User;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    public void save(User user)
    {
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("USER");
        if(roleId != 0 && userId !=0)
        {
            userRepository.addRoleaToUser(userId, roleId);
        }
    }
}
