package com.incident.incidentManagement.repository;

import com.incident.incidentManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    void deleteByUserName(String userName);

    User findByUserName(String userName);
}
