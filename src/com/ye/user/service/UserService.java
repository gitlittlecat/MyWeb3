package com.ye.user.service;

import com.ye.user.dao.UserDao;
import com.ye.user.domain.User;

public class UserService {
    public void register(User user) {
        UserDao dao = new UserDao();
        dao.save(user);
    }
}
