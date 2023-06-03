package trinhquangtan.demo.Validator.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import trinhquangtan.demo.Repository.IUserRepository;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context)
    {
        if(userRepository == null)
            return true;
        return userRepository.findByUsername(username) == null;
    }
}
