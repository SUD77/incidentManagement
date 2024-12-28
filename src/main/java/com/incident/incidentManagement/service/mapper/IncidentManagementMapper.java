package com.incident.incidentManagement.service.mapper;

import com.incident.incidentManagement.dtos.AddressDto;
import com.incident.incidentManagement.dtos.UserDto;
import com.incident.incidentManagement.entity.Address;
import com.incident.incidentManagement.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true),unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IncidentManagementMapper {

    IncidentManagementMapper INSTANCE= Mappers.getMapper(IncidentManagementMapper.class);

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

    AddressDto toAddressDto(Address address);

    Address toAddress(AddressDto addressDto);
}
