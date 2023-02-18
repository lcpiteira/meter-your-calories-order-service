package com.meter.your.calories.OrderService.services.impl;

import com.meter.your.calories.OrderService.models.entities.UserEntity;
import com.meter.your.calories.OrderService.repositories.UserRepository;
import com.meter.your.calories.OrderService.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUserByEmail(String email) throws Exception {
        Optional<UserEntity> userEntityOpt = userRepository.findUserEntitiesByEmail(email);
        if(userEntityOpt.isEmpty()){
            throw new Exception("Does not exist any user registered with email "+ email);
        }
        return userEntityOpt.get();
    }
}
