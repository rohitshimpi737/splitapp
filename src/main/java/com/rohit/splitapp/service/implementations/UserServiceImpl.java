package com.rohit.splitapp.service.implementations;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rohit.splitapp.constants.enums.RegistrationMethod;
import com.rohit.splitapp.persistence.dto.user.PhoneDTO;
import com.rohit.splitapp.persistence.dto.user.RegisterUserRequest;
import com.rohit.splitapp.persistence.dto.user.UserDTO;
import com.rohit.splitapp.persistence.entities.Group;
import com.rohit.splitapp.persistence.entities.User;
import com.rohit.splitapp.repository.GroupRepository;
import com.rohit.splitapp.repository.UserRepository;
import com.rohit.splitapp.service.interfaces.UserService;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private BCryptPasswordEncoder pwdEncoder;

    // for save and update
    @Override
    @Transactional
    public String saveUser(RegisterUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setCountryCode(request.getPhone().getCountryCode());
        user.setPhoneNumber(request.getPhone().getPhoneNumber());
        user.setPassword(pwdEncoder.encode(request.getPassword()));
        user.setRegistrationMethod(RegistrationMethod.NORMAL);
        user = userRepository.save(user);
        Group group = new Group();
        group.setGroupName("Non Grouped Expenses");
        group.setUser(user);
        group.setDefaultGroup(true);
        groupRepository.save(group);
        return user.getId().toString();
    }

    @Override
    public UserDTO findUser() {
        User user = authorizationService.getAuthorizedUser();
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                new PhoneDTO(user.getCountryCode(), user.getPhoneNumber())
        );
    }

    @Override
    @Transactional
    public String deleteUser() {
        User user = authorizationService.getAuthorizedUser();
        userRepository.deleteById(user.getId());
        return "%s - user deleted.".formatted(user.getId());
    }

    @Override
    @Transactional
    public String updateUser(RegisterUserRequest request) {
        User user = authorizationService.getAuthorizedUser();
        if(!user.getEmail().equals(request.getEmail())) throw new AccessDeniedException("You are not authenticated for updating this account");
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setCountryCode(request.getPhone().getCountryCode());
        user.setPhoneNumber(request.getPhone().getPhoneNumber());
        user.setPassword(pwdEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return request.getUsername() + " updated successfully.";
    }

}
