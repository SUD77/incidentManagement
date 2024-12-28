package com.incident.incidentManagement.service;

import com.incident.incidentManagement.dtos.UserDto;
import com.incident.incidentManagement.entity.User;
import com.incident.incidentManagement.exceptions.UserAlreadyExistsException;
import com.incident.incidentManagement.repository.UserRepository;
import com.incident.incidentManagement.service.mapper.IncidentManagementMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDto userDto) {
        User existingUser=userRepository.findByUserName(userDto.getUserName());
        if (existingUser != null) {
            throw new UserAlreadyExistsException(userDto.getUserName());
        }
        User user = IncidentManagementMapper.INSTANCE.toUser(userDto);
        userRepository.save(user);
    }


    @Transactional
    public void deleteUser(String userName) {
        userRepository.deleteByUserName(userName);
    }

}
