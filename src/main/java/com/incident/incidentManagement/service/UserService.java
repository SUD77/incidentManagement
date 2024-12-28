package com.incident.incidentManagement.service;

import com.incident.incidentManagement.dtos.UserDto;
import com.incident.incidentManagement.entity.Address;
import com.incident.incidentManagement.entity.User;
import com.incident.incidentManagement.exceptions.UserAlreadyExistsException;
import com.incident.incidentManagement.exceptions.UserNotFoundException;
import com.incident.incidentManagement.repository.AddressRepository;
import com.incident.incidentManagement.repository.UserRepository;
import com.incident.incidentManagement.service.mapper.IncidentManagementMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

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
        User existingUser = userRepository.findByUserName(userName);

        if (existingUser == null) {
            throw new UserNotFoundException(userName);
        }
        userRepository.deleteByUserName(userName);
    }

    @Transactional
    public User updateUser(String userName, UserDto updatedUser) {
        User existingUser = userRepository.findByUserName(userName);

        if (existingUser == null) {
            throw new UserNotFoundException(userName);
        }

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhone(updatedUser.getPhone());

        existingUser.setPassword(updatedUser.getPassword());

        updateAdress(existingUser, updatedUser);

        return userRepository.save(existingUser);

    }

    private void updateAdress(User existingUser, UserDto updatedUser) {
        // Address update logic
        if (updatedUser.getAddress() != null) {

            if (existingUser.getAddress() == null) {
                existingUser.setAddress(updatedUser.getAddress());
            } else {
                Address existingAddress = existingUser.getAddress();

                // Check if the address is still valid (not deleted)
                if (addressRepository.existsById(existingAddress.getId())) {

                    Address updatedAddress = updatedUser.getAddress();

                    existingAddress.setStreetAddress(updatedAddress.getStreetAddress());
                    existingAddress.setCity(updatedAddress.getCity());
                    existingAddress.setState(updatedAddress.getState());
                    existingAddress.setPinCode(updatedAddress.getPinCode());
                    existingAddress.setCountry(updatedAddress.getCountry());

                    addressRepository.save(existingAddress);
                } else {
                    throw new UserNotFoundException("Address not found for user: " + existingUser.getUserName());
                }
            }
        }
    }

}
