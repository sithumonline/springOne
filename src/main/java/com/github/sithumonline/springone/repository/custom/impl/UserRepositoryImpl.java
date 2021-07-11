package com.github.sithumonline.springone.repository.custom.impl;

import com.github.sithumonline.springone.entity.Users;
import com.github.sithumonline.springone.repository.custom.UserRepository;
import com.github.sithumonline.springone.repository.impl.SuperRepositoryImpl;

public class UserRepositoryImpl extends SuperRepositoryImpl<Users, String> implements UserRepository {
}
