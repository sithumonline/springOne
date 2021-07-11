package com.github.sithumonline.springone.repository.custom;

import com.github.sithumonline.springone.entity.Users;
import com.github.sithumonline.springone.repository.SuperRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends SuperRepository<Users, String>{
}
