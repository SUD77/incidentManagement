package com.incident.incidentManagement.dtos;

import com.incident.incidentManagement.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private AddressDto address;
    private String email;
    private String phone;
}
