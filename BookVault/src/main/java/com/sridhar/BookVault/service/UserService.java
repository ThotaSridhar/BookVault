package com.sridhar.BookVault.service;

import com.sridhar.BookVault.domain.Users;

public interface UserService {
    public Users register(Users user);

    String logging(Users user);
}
