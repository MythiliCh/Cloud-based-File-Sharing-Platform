package com.cloud.file.sharing.repository;

//src/main/java/com/cloud/filesharing/repository/UserRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.file.sharing.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
 // Placeholder for repository methods
	
}